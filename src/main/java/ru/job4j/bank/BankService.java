package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает модель для банковской системы.
 * В системе можно производить следующие действия.
 * 1. Регистрировать пользователя.
 * 2. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 3. Переводить деньги с одного банковского счета на другой счет.
 *
 * @author SERGEY BAZARNOV
 * @version 1.0
 */
public class BankService {
    /**
     * Поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему
     * В методе осуществляется проверка, что такого пользователя еще нет в системе
     *
     * @param user пользователь который добавляется в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет к пользователю
     * Первоначально находит пользователя по паспорту;
     * После этого мы получаем список всех счетов пользователя и добавим новый счет к ним
     *
     * @param passport пасспорт пользователя
     * @param account  банковский счет пользователя
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accountList = users.get(user.get());
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     *
     * @param passport пасспорт пользователя
     * @return Возвращает найденного пользователя.
     * Если пользователь не найден, метод возвращает null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * Сначала метод находит пользователя по паспорту с помощью метода findByPassport.
     * Потом получает список счетов этого пользователя и в нем находит нужный счет.
     *
     * @param passport  пасспорт пользователя
     * @param requisite реквизиты пользователя
     * @return Метод возвращает счет пользователя.
     * Если пользователь не найден, метод возращает null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.map(value -> users.get(value)
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst()).orElse(null);
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     *
     * @param srcPassport   пасспорт пользователя с которого переводят деньги
     * @param srcRequisite  реквизиты пользователя с которого переводят деньги
     * @param destPassport  пасспорт пользователя которому переводят деньги
     * @param destRequisite реквизиты пользователя которому переводят деньги
     * @param amount        сумма перевода
     * @return возвращает true если перевод выполнен успешно, иначе false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
