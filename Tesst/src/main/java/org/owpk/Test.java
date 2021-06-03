package org.owpk;

public class Test {
    public static void main(String[] args) throws Exception {
        Player upd = new Player();
        upd.setName("Ivan");
        upd.setRole(Role.USER);

        Player player = new Player();
        player.setAge(13);
        player.setId(3);
        player.setName("Igor");
        player.setRole(Role.ADMIN);

        Player p = ReflectUtils.updateAllFields(player, upd);
        System.out.println(p);
    }
}
