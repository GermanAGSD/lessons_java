package org.example;

import com.unboundid.ldap.sdk.*;

public class LdapExample {

    public static void ldapConnect() {
        String host = "172.30.30.3";
        int port = 389; // стандартный порт LDAP
        String bindDN = "CN=my-service,CN=Users,DC=bull,DC=local";
        String password = "Nhb;ls<sr-3";
        String baseDN = "DC=bull,DC=local";

        LDAPConnection connection = null;

        try {
            // Подключение
            connection = new LDAPConnection(host, port, bindDN, password);
            System.out.println("✅ Подключено к LDAP");

            // Простой поиск всех пользователей с objectClass=user
            SearchResult result = connection.search(
                    baseDN,
                    SearchScope.SUB,
                    "(objectClass=user)" // можно заменить на свой фильтр
            );

            for (SearchResultEntry entry : result.getSearchEntries()) {
                System.out.println("DN: " + entry.getDN());
                System.out.println("CN: " + entry.getAttributeValue("cn"));
                System.out.println("Email: " + entry.getAttributeValue("mail"));
                System.out.println("------------");
            }

        } catch (LDAPException e) {
            System.err.println("❌ Ошибка подключения или поиска: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
                System.out.println("🔌 Соединение закрыто");
            }
        }
    }
}
