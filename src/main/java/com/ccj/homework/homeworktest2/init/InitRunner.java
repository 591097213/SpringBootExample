package com.ccj.homework.homeworktest2.init;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import com.ccj.homework.homeworktest2.dao.AccountRepository;
import com.ccj.homework.homeworktest2.dao.AddressRepository;
import com.ccj.homework.homeworktest2.dao.AppRepository;
import com.ccj.homework.homeworktest2.dao.PhoNumRepository;
import com.ccj.homework.homeworktest2.dao.UserRepository;
import com.ccj.homework.homeworktest2.entity.Account;
import com.ccj.homework.homeworktest2.entity.Address;
import com.ccj.homework.homeworktest2.entity.App;
import com.ccj.homework.homeworktest2.entity.PhoNum;
import com.ccj.homework.homeworktest2.entity.User;
import com.ccj.homework.homeworktest2.service.initservice.RandomUtils;
import com.ccj.homework.homeworktest2.service.initservice.RandomUtils.CharType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitRunner implements ApplicationRunner {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AppRepository appRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PhoNumRepository phoNumRepository;

    @Value("${initDB}")
    private boolean initDB;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("*************************" + this.initDB);
        if (this.initDB) {
            // 插入i个User
            for (int i = 0; i < 10; i++) {
                User user = new User();
                boolean sex = RandomUtils.getSex();
                String name = RandomUtils.getChineseName(sex);
                String email = RandomUtils.getEmail(6, 12);
                short age = (short) RandomUtils.getRandomNumber(3, 80);

                Collection<Account> accounts =
                        initAccountsAndPnoNums(RandomUtils.getRandomNumber(1, 3));
                Collection<Address> addresses = initAddresses(RandomUtils.getRandomNumber(1, 3));
                Collection<App> apps = initApps(RandomUtils.getRandomNumber(1, 3));
                // Collection<PhoNum> phoNums = initPhoNUms(RandomUtils.getRandomNumber(1, 3));
                user.setName(name);
                user.setSex(sex);
                user.setEmail(email);
                user.setAge(age);
                user.setAccounts(accounts);
                user.setAddresses(addresses);
                user.setApps(apps);

                userRepository.save(user);

                Collection<User> users = new ArrayList<User>();
                users.add(user);

                for (Account tempAccount : (ArrayList<Account>) accounts) {
                    tempAccount.setUser(user);
                    accountRepository.save(tempAccount);
                }

                for (Address tempAddress : addresses) {
                    tempAddress.setUsers(users);
                    addressRepository.save(tempAddress);
                }

                for (App tempApp : apps) {
                    tempApp.setUsers(users);
                    appRepository.save(tempApp);
                }

            }


        }
    }

    public Collection<Account> initAccountsAndPnoNums(int num) {

        Collection<Account> accounts = new ArrayList<Account>();

        for (int i = 0; i < num; i++) {
            Account account = new Account();
            String accountName =
                    RandomUtils.getStr(6, CharType.Number, CharType.LowerCase, CharType.UpperCase);

            String pwd =
                    RandomUtils.getStr(6, CharType.Number, CharType.LowerCase, CharType.UpperCase);

            account.setAccountName(accountName);
            account.setPwd(pwd);

            accountRepository.save(account);

            PhoNum phoNum = new PhoNum();
            String phonum = RandomUtils.getPhone();
            phoNum.setNum(phonum);
            phoNumRepository.save(phoNum);

            phoNum.setAccount(account);
            account.setPhoNum(phoNum);

            phoNumRepository.save(phoNum);
            accountRepository.save(account);

            accounts.add(account);

        }
        return accounts;

    }

    public Collection<Address> initAddresses(int num) {

        Collection<Address> addresses = new ArrayList<Address>();
        for (int i = 0; i < num; i++) {
            Address address = new Address();
            String addressName = RandomUtils.getRoad();

            address.setAddressName(addressName);
            addressRepository.save(address);

            addresses.add(address);

        }
        return addresses;
    }

    public Collection<App> initApps(int num) {
        Collection<App> apps = new ArrayList<App>();
        for (int i = 0; i < num; i++) {
            App app = new App();
            String appId = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            String appSecret =
                    RandomUtils.getStr(6, CharType.Number, CharType.LowerCase, CharType.UpperCase);
            app.setAppId(appId);
            app.setAppSecret(appSecret);

            appRepository.save(app);
            apps.add(app);
        }
        return apps;
    }

}

