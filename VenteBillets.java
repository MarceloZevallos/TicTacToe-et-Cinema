/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gg.sim.mzevallos.devoir3;

import java.util.Locale;

/**
 *
 * @mzevallos
 */
public class VenteBillets {
    
    // créations de variables
    static int rangee = 15;
    static int colone = 30;
    static double[][] siegeTarif = new double[rangee][colone];
    static char[][] siege2D = new char[rangee][colone];
    static double totalProfit = 0.00;
    static int totalBillet = 0;
    
    static char[][] AfficherLesPlacesDisponibles(char[][] siege){
        
        // on affiche les places
        System.out.println("                           Sièges");
        for (int i = 0; i < 15; i++) {
            
            String nRangee = String.format(Locale.US,"Rangée %2d %4s", i + 1, ' ');
                System.out.print(nRangee);
            
            for (int j = 0; j < colone; j++) {
                String vSiege= String.format(Locale.US,"%1S", siege[i][j]);
                System.out.print(vSiege);
                
            }
            System.out.println();
        }
        System.out.println("\n          Légende: * = Vendu, # = Disponible \n");
        
        return siege;
    } // afficher les places disponibles
   
    static void AfficherLesTarifs(){
        
        // afficher les tarifs
        System.out.println("Tarifs des billets par rangée \n"
                         + "        Rangée        Prix \n"
                         + "        ------        ---- \n"
                         + "             1      200.00 \n"
                         + "             2      180.00 \n"
                         + "             3      160.00 \n"
                         + "             4      140.00 \n"
                         + "             5      120.00 \n"
                         + "             6      100.00 \n"
                         + "             7       80.00 \n"
                         + "             8       60.00 \n"
                         + "             9       40.00 \n"
                         + "            10       30.00 \n"
                         + "            11       30.00 \n"
                         + "            12       30.00 \n"
                         + "            13       30.00 \n"
                         + "            14       30.00 \n"
                         + "            15       30.00 \n");
    } // afficher les tarifs
    
    static void AfficherLeTotalDesVentes(){
        
        //affiche les profits
        System.out.println("Le nombre total de siège vendu est: " + totalBillet + " billets.");
        System.out.println("Le total des ventes est $" + totalProfit);
        System.out.println();
    } // afficher le total des ventes
    
    static char[][] AcheterUnBillet(double prixUtilisateur, int billetUtilisateur){
        
        boolean continuer = true;
        
        while(continuer){
        
            while(continuer){
                
                char visualizer = Utilitaires.lireChar("\nVoulez vous vizualizer les places disponibles"
                                    + "\n avant de faire vos selection? (o/n)? ");
        
                // si on veut voir les sièges
                if(visualizer == 'o'){
            
                    for (int i = 0; i < rangee; i++) {
                        for (int j = 0; j < colone; j++) {
                            siegeTarif[i][j] = i + j;
                        }
                    }
        
                    System.out.println("                           Sièges");
                    for (int i = 0; i < 15; i++) {
            
                        String nRangee = String.format(Locale.US,"Rangée %2d %4s", i + 1, ' ');
                        System.out.print(nRangee);
            
                        for (int j = 0; j < colone; j++) {
                            String resultatExclu= String.format(Locale.US,"%1S", siege2D[i][j]);
                            System.out.print(resultatExclu);
                
                
                        }
                        System.out.println();
                    }
                    System.out.println("\n          Légende: * = Vendu, # = Disponible \n");
                    break;
            
                } /*Si on veut pas voir les sièges*/ else if (visualizer != 'n'){
            
                    System.out.println("\nSVP entrez une valeur valide!");
            
                }/*Si c'est aucun*/ else if (visualizer == 'n'){
                    break;
                }
            }
            
            int aRangee = (int) Utilitaires.lireEntier("\nSVP entrez le numéro de la rangée (1 - 15): ");
        
            int aColone = (int) Utilitaires.lireEntier("\nSVP entrez le numéro du siège (1 - 30): ");
        
            // Si le siège est déja vendu
            if(siege2D[aRangee-1][aColone-1] == '*'){
                System.out.println("\nDésolé, ce siège a été vendu");
            }/*Si le siège est disponible*/ else if (siege2D[aRangee-1][aColone-1] == '#'){
            
                siege2D[aRangee-1][aColone-1] = '*';
                billetUtilisateur = billetUtilisateur + 1;
                totalBillet = totalBillet + 1;
            
                prixUtilisateur = prixUtilisateur + siegeTarif[aRangee-1][aColone-1] + 0.000;
                totalProfit = totalProfit + siegeTarif[aRangee-1][aColone-1];
                
                System.out.println("\nAchat confirmé");
            
                // on demande si le client veut un autre siège
                while(continuer){
        
                    char arret = (char) Utilitaires.lireChar("\nVoulez-vous acheter un autre siège (o/n)?");
        
                    // Si il veut pas un autre siège
                    if(arret == 'n'){
                        System.out.println("\nVous avex acheté un total de " + billetUtilisateur + " billets pour un prix"
                                + " total de $" + prixUtilisateur + "0");
                        return siege2D;
                    }/*Si c'est aucun*/ else if (arret != 'o'){
                        System.out.println("\nSVP entrez une valeur demandée");
                    }/*Si il veut un autre siège*/ else if (arret == 'o'){
                        break;
                    }
                    return siege2D;
                }
            
            }
        
        
        }
        
        return siege2D;
    } // acheter un billet
    
    
    public void resoudre(){
        
        boolean encore = true;
        
        
        // on met les prix dans siegeTarif et les siège dans siege2D
        for (int i = 0; i < 15; i++) {
            
            for (int j = 0; j < colone; j++) {
                
                siegeTarif[i][j] = 30.00;
                siegeTarif[0][j] = 200.00;
                siegeTarif[1][j] = 180.00;
                siegeTarif[2][j] = 160.00;
                siegeTarif[3][j] = 140.00;
                siegeTarif[4][j] = 120.00;
                siegeTarif[5][j] = 100.00;
                siegeTarif[6][j] = 80.00;
                siegeTarif[7][j] = 60.00;
                siegeTarif[8][j] = 40.00;
                
                
                siege2D[i][j] = '#';
                
            }
        } // creation des deux tableaux
        
        
        
        
        while(encore = true){
            
            // Menu
            System.out.println("\n Menu Principal \n");
            System.out.println("1. Afficher les places disponibles\n" +
                               "2. Afficher les tarifs\n" +
                               "3. Afficher le total des ventes\n" +
                               "4. Acheter un billet\n" +
                               "5. Quitter \n"); 
            
            int input = (int) Utilitaires.lireEntier("Veuillez SVP choisir une option (1-5): ");
            System.out.println();
            
            if(input < 1 || input >= 6){
                System.out.println("SVP entrez une valeur demandée");
            } else if (input == 1){
                AfficherLesPlacesDisponibles(siege2D);
            }else if (input == 2){
                AfficherLesTarifs();
            }else if (input == 3){
                AfficherLeTotalDesVentes();
            }else if (input == 4){
                AcheterUnBillet(0.00, 0);
            }else if (input == 5){
                encore = false;
                break;
            }
            
        }// Menu principale

    }// resoudre
    
}//class
