package org.example;
import com.unboundid.ldap.sdk.*;
import com.unboundid.ldap.sdk.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class LdapAuth {

    private static final String LDAP_HOST = "172.30.30.3";
    private static final int LDAP_PORT = 389;
    private static final String BASE_DN = "DC=bull,DC=local";
    private static final String SERVICE_BIND_DN = "CN=my-service,CN=Users,DC=bull,DC=local";
    public static final String SERVICE_PASSWORD = "Nhb;ls<sr-3";
    private static final String SECRET = "mySuperSecretKey12345678901234567890"; // минимум 32 символа для HS256
    public static final Key SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

//    public static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256); // сгенерируем случайный ключ

    public static String authenticateAndGenerateToken(String login, String password) {
        LDAPConnection serviceConnection = null;

        try {
            serviceConnection = new LDAPConnection(LDAP_HOST, LDAP_PORT, SERVICE_BIND_DN, SERVICE_PASSWORD);

            // Поиск DN по логину
            Filter filter = Filter.createEqualityFilter("sAMAccountName", login);
            SearchResult result = serviceConnection.search(BASE_DN, SearchScope.SUB, filter);

            if (result.getEntryCount() == 0) {
                System.out.println("❌ Пользователь не найден: " + login);
                return null;
            }

            String userDN = result.getSearchEntries().get(0).getDN();
            System.out.println("🔍 Найден DN: " + userDN);

            // Проверка пароля
            LDAPConnection userConn = new LDAPConnection(LDAP_HOST, LDAP_PORT);
            try {
                userConn.bind(userDN, password);
                System.out.println("✅ Аутентификация прошла успешно");

                // Генерация JWT
                long nowMillis = System.currentTimeMillis();
//                long expMillis = nowMillis + 3600;
                long expMillis = nowMillis + 1000L * 60 * 60 * 24 * 30 * 6; // ~6 месяцев

                String jwt = Jwts.builder()
                        .setSubject(login)
                        .claim("dn", userDN)
                        .setIssuedAt(new Date(nowMillis))
                        .setExpiration(new Date(expMillis))
                        .signWith(SECRET_KEY)
                        .compact();

                return jwt;

            } catch (LDAPException e) {
                System.out.println("❌ Неверный пароль");
                return null;
            } finally {
                userConn.close();
            }

        } catch (LDAPException e) {
            System.err.println("Ошибка LDAP: " + e.getMessage());
            return null;
        } finally {
            if (serviceConnection != null) {
                serviceConnection.close();
            }
        }
    }
}

//
//public class LdapAuth {
//    static boolean authenticated = false;
//
//    public static boolean authenticate(String username, String password) {
//        String ldapHost = "dcbull";
//        int ldapPort = 389;
//
//        String netbiosLogin = username;
//        String userPassword = password;
//
//        // получаем sAMAccountName из строки входа
//
//        String baseDN = "DC=bull,DC=local";
//        String serviceBindDN = "CN=my-service,CN=Users,DC=bull,DC=local";
//        String servicePassword = "Nhb;ls<sr-3";
//
//        LDAPConnection serviceConnection = null;
//
//        try {
//            // 1. Подключаемся как сервисный аккаунт
//            serviceConnection = new LDAPConnection(ldapHost, ldapPort, serviceBindDN, servicePassword);
//
//            // 2. Ищем DN пользователя по sAMAccountName
//            Filter filter = Filter.createEqualityFilter("sAMAccountName", netbiosLogin);
//            SearchResult result = serviceConnection.search(baseDN, SearchScope.SUB, filter);
//
//            if (result.getEntryCount() == 0) {
//                System.out.println("❌ Пользователь не найден: " + netbiosLogin);
//                return false;
//            }
//
//            String userDN = result.getSearchEntries().get(0).getDN();
//            System.out.println("🔍 Найден DN: " + userDN);
//
//            // 3. Пытаемся авторизоваться от имени пользователя
//            LDAPConnection userConn = new LDAPConnection(ldapHost, ldapPort);
//            try {
//                userConn.bind(userDN, userPassword);
//                System.out.println("✅ Успешная аутентификация для: " + netbiosLogin);
//                authenticated = true;
//                return true;
//            } catch (LDAPException e) {
//                System.out.println("❌ Неверный пароль для " + netbiosLogin);
//                authenticated = false;
//                return false;
//            } finally {
//                userConn.close();
//            }
//
//        } catch (LDAPException e) {
//            System.err.println("Ошибка при подключении: " + e.getMessage());
//            authenticated = false;
//            return false;
//        } finally {
//            if (serviceConnection != null) {
//                serviceConnection.close();
//            }
//        }
//    }
//}

//
//public class LdapAuth {
//    public static void authenticate(String username) {
//        String ldapHost = "172.30.30.3";
//        int ldapPort = 389;
////        String username = "Баклагин Герман Сергеевич";
//
//        // Полный DN пользователя
//        String userDN = String.format("CN=%s,OU=508-509 кабинет - IT,OU=Газойл,OU=Офис,OU=Пользователи,DC=bull,DC=local", username);
//
//        // Пароль, введённый пользователем
//        String userPassword = "XXLPR6";
//
//        LDAPConnection connection = null;
//
//        try {
//            // Пытаемся выполнить bind от имени пользователя
//            connection = new LDAPConnection(ldapHost, ldapPort, userDN, userPassword);
//            System.out.println("✅ Аутентификация прошла успешно для: " + userDN);
//        } catch (LDAPException e) {
//            System.err.println("❌ Ошибка аутентификации: " + e.getMessage());
//        } finally {
//            if (connection != null) {
//                connection.close();
//                System.out.println("🔌 Соединение закрыто");
//            }
//        }
//    }
//}

//import com.unboundid.ldap.sdk.*;
//
//public class LdapAuth {
//    public static void authenticate() {
//        String ldapHost = "172.30.30.3";
//        int ldapPort = 389;
//        String serviceBindDN = "CN=my-service,CN=Users,DC=bull,DC=local";
//        String servicePassword = "Nhb;ls<sr-3";
//        String baseDN = "DC=bull,DC=local";
//
//        String inputUsername = "badm";
//        String inputPassword = "Nhb;ls<sr-3";
//
//        LDAPConnection connection = null;
//
//        try {
//            // 1. Подключаемся как сервисный аккаунт
//            connection = new LDAPConnection(ldapHost, ldapPort, serviceBindDN, servicePassword);
//            System.out.println("✅ Сервисное подключение успешно");
//
//            // 2. Ищем пользователя по CN
//            Filter filter = Filter.createEqualityFilter("cn", inputUsername);
//            SearchResult searchResult = connection.search(baseDN, SearchScope.SUB, filter);
//
//            if (searchResult.getEntryCount() == 0) {
//                System.out.println("❌ Пользователь не найден");
//                return;
//            }
//
//            // 3. Получаем DN найденного пользователя
//            SearchResultEntry userEntry = searchResult.getSearchEntries().get(0);
//            String userDN = userEntry.getDN();
//            System.out.println("🔍 Найден DN пользователя: " + userDN);
//
//            // 4. Пробуем подключиться от имени найденного пользователя
//            LDAPConnection userConnection = new LDAPConnection(ldapHost, ldapPort);
//
//            try {
//                userConnection.bind(userDN, inputPassword);
//                System.out.println("✅ Аутентификация прошла успешно для: " + inputUsername);
//            } catch (LDAPException e) {
//                System.out.println("❌ Неверный пароль для пользователя: " + inputUsername);
//            } finally {
//                userConnection.close();
//            }
//
//        } catch (LDAPException e) {
//            System.err.println("❌ Ошибка: " + e.getMessage());
//        } finally {
//            if (connection != null) {
//                connection.close();
//            }
//        }
//    }
//}
