import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Création du personnage
        System.out.println("------------------------------");
        System.out.println("--- Création du personnage ---");
        System.out.println("------------------------------");
        // Choix du nom du personnage
        System.out.println("Quel est le nom de votre personnage ?");
        String name = scanner.nextLine();
        // Choix du type de personnage
        System.out.println("Quel type de personnage voulez-vous créer ? (Guerrier , Magicien ou Archer)");
        String role;
        do {
            role = scanner.nextLine();
        } while (!role.equals("Guerrier") && !role.equals("Magicien") && !role.equals("Archer"));
        // Instanciation du personnage
        Character player = new Character("", 10, 5);
        switch (role) {
            case "Guerrier" -> {
                player = new Warrior(name);
            }
            case "Magicien" -> {
                player = new Magician(name);
            }
            case "Archer" -> {
                player = new Archer(name);
            }
        }

        // Choix de l'épée pour les guerriers
        if (role.equals("Guerrier")) {
            // Instanciation des épées
            Sword excalibur = new Sword("Excalibur", 4, 1);
            Sword durendal = new Sword("Durendal", 2, 5);
            // Choix de l'épée
            System.out.println("Quelle épée voulez-vous porter ? (Excalibur ou Durendal)");
            String sword;
            do {
                sword = scanner.nextLine();
            } while (!sword.equals("Excalibur") && !sword.equals("Durendal"));
            // Équipemenent de l'épée
            switch (sword) {
                case "Excalibur" -> {
                    ((Warrior) player).setSword(excalibur);
                }
                case "Durendal" -> {
                    ((Warrior) player).setSword(durendal);
                }
            }
        }
        if (role.equals("Archer")){
            Bow bow1 = new Bow("normalBow",4,3,0.75);
            Bow bow2 = new Bow("devilBow",1,666,0.2);
            Bow bow3 = new Bow("luckBow",777,0,0.1);
            System.out.println("Quelle arc voulez-vous porter ? (normalBow , devilBow, luckBow)");
            String bow;
            do {
                bow = scanner.nextLine();
            } while (!bow.equals("normalBow") && !bow.equals("devilBow") && !bow.equals("luckBow"));
            // Équipemenent de l'arc
            switch (bow) {
                case "normalBow" -> {
                    ((Archer) player).setBow(bow1);
                }
                case "devilBow" -> {
                    ((Archer) player).setBow(bow2);
                }
                case "luckBow" -> {
                    ((Archer) player).setBow(bow3);
                }
            }
        }

        // Déroulement du jeu
        System.out.println("------------------------------");
        System.out.println("---------- P L A Y -----------");
        // Boucle de jeu
        while (player.getLife() > 0) {
            // Choix de la prochaine tâche réalisée par le joueur
            System.out.println("------------------------------");
            System.out.println("État " + player.getName() + " : " + player.getLife() + "/" + player.getLifeMAX() + " PV");
            System.out.println("Que souhaitez-vous faire ?" +
                    "\n  Tapez 1 pour Affronter un ennemi faible" +
                    "\n  Tapez 2 pour Affronter un ennemi moyen" +
                    "\n  Tapez 3 pour Affronter un ennemi fort");
            String choice = scanner.nextLine();
            // Lancement de la tâche
            switch (choice) {
                case "1" -> fight(player, "Rat", 4, 1);
                case "2" -> fight(player, "Chien sauvage", 7, 3);
                case "3" -> fight(player, "Loup", 15, 5);
                default -> System.out.println("Choix inconnu !");
            }
        }

        // Fin du jeu
        System.out.println("------------------------------");
        System.out.println("------ G A M E O V E R ------");
        System.out.println("------------------------------");
    }

    public static void fight(Character player, String nameOpponent, int lifeOpponent, int strengthOpponent) {
        Scanner scanner = new Scanner(System.in);
        int round = 1;
        boolean escape = false;
        // Création de l'adversaire
        Character opponent = new Character(nameOpponent, lifeOpponent, strengthOpponent);
        // Boucle de combat
        while (player.getLife() > 0 && opponent.getLife() > 0 && escape == false) {
            // Choix de la prochaine action du joueur
            System.out.println("--- Tour " + round + " ---");
            System.out.print("Quelle action souhaitez-vous faire ?" +
                    "\n  Tapez 1 pour Attaquer" +
                    "\n  Tapez 2 pour Fuir");
            if (player.getClass().toString().equals("class Magician")) {
                System.out.print("  Tapez 3 pour Lancer une boule de feu");
            }
            System.out.println();
            String action = scanner.nextLine();
            // Réalisation de la prochaine action du joueur
            switch (action) {
                case "1" -> {
                    int damage = player.attack(opponent);
                    System.out.println(player.getName() + " attaque " +
                            opponent.getName() + " et lui cause " + damage + " dégats");
                }
                case "2" -> {
                    escape = player.escape();
                    if (escape) {
                        System.out.println(player.getName() + " a fuit le combat.");
                    } else {
                        System.out.println(player.getName() + " a raté sa tentative de fuite.");
                    }
                }
                case "3" -> {
                    int damage = ((Magician) player).fireBall(opponent);
                    if (damage > 0) {
                        System.out.println(player.getName() + " envoie une boule de feu sur " +
                                opponent.getName() + " et lui cause " + damage + " dégats");
                    } else {
                        System.out.println(player.getName() + " créé une boule de feu qui se retourne " +
                                "contre lui et lui cause " + damage + " dégats");
                    }
                }
                default -> System.out.println("Action de " + player.getName() + " inconnue !");
            }
            // Réalisation de l'action de l'adversaire
            int damage = opponent.attack(player);
            System.out.println(opponent.getName() + " attaque " + player.getName() +
                    " et lui cause " + damage + " dégats");
            // Affichage de l'état des 2 combattants
            System.out.println("État " + player.getName() + " : " + player.getLife() + "/" + player.getLifeMAX() + " PV");
            System.out.println("État " + opponent.getName() + " : " + opponent.getLife() + "/" + opponent.getLifeMAX() + " PV");
            round++;
        }
        // Gestion de la fin du combat
        if (player.getLife() == 0) {
            System.out.println("Votre personnage est mort !");
        }
        if (player.getLife() != 0 ) {
            System.out.println("Vous avez vaincu " + opponent.getName() + " !");
        }
    }
}