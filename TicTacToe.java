/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gg.sim.mzevallos.devoir3;
import java.util.Scanner;

/**
 *
 * @mzevallos
 */
public class TicTacToe {
    
    // créations de variables
     static char[][] tableau = {{'-', '-', '-'},{ '-', '-', '-'},{'-', '-', '-'}};
     static char[][] afficheurTableau = new char[tableau.length][];
     
     int len, index;
     static int joueur = Utilitaires.genererAleatoire(2, 1);
     static char gagnant = ' ';

    
    static char[][] convertirPosition(int i, int j){
        
        // Si le joueur est X
        if(joueur == 1){
            Scanner myObj = new Scanner(System.in);  // Crée un objet Scanner
            System.out.print("JoueurX, position: ");

            String position = myObj.nextLine();  // Lit le input de l'utilisatuer
            
            String[] positionTableau = position.strip().split(",", 2);
            
            boolean ok=true;
            
            // on va chercher des eureurs
            try {
                i = Integer.parseInt(positionTableau[0]);
            }
            catch(Exception e) {
                   System.out.println("Entrez une position de la forme i, j où i et j sont entre 1 et 3");
                   ok=false;
                   joueur = 1;
                   return null;
            }
            try {
                 j = Integer.parseInt(positionTableau[1]);
            }
            catch(Exception e) {
                   System.out.println("Entrez une position de la forme i, j où i et j sont entre 1 et 3");
                   ok=false;
                   joueur = 1;
                   return null;
               
            }
            
           
            if ((ok) && (i>0) && (i<=3) && (j>0) && (j<=3)) {

                // voir si la position est déja occupé
                if(tableau[i-1][j-1] == '0' || tableau[i-1][j-1] == 'X'){
                    
                    System.out.println("cette position est déjà occupé");
                    joueur = 1;
                    //System.out.println(joueur);
                    return null;
            
                } else {
                    
                    tableau[i-1][j-1] = 'X';
                    joueur = joueur + 1;
                    //System.out.println(joueur);
                    return tableau;
                }

            } 
            
            
        }/* Si le joueur est O */ else if(joueur == 2){
            
            Scanner myObj = new Scanner(System.in);  // Crée un objet Scanner
            System.out.print("JoueurO, position: ");

            String position = myObj.nextLine();  // Lit le input de l'utilisateur 
            
            String[] positionTableau = position.strip().split(",", 2);

            boolean ok=true;
            
            // on va chercher des eureurs
            try {
                i = Integer.parseInt(positionTableau[0]);
            }
            catch(Exception e) {
                   System.out.println("Entrez une position de la forme i, j où i et j sont entre 1 et 3");
                   ok=false;
                   joueur = 2;
                   //System.out.println(joueur);
                   return null;
            }
            try {
                 j = Integer.parseInt(positionTableau[1]);
            }
            catch(Exception e) {
                   System.out.println("Entrez une position de la forme i, j où i et j sont entre 1 et 3");
                   ok=false;
                   joueur = 2;
                   //System.out.println(joueur);
                   return null;
               
            }
            if ((ok) && (i>0) && (i<=3) && (j>0) && (j<=3)) {
          
                // voir si la position est déja occupé
                if(tableau[i-1][j-1] == '0' || tableau[i-1][j-1] == 'X'){
                    
                    System.out.println("cette position est déjà occupé");
                    joueur = 2;
                    return null;
            
                } else {
                    
                    tableau[i-1][j-1] = '0';
                    joueur = joueur - 1;
                    return tableau;
                }
            } 

        } // joueur0
        return null;
    }
    
    static char verifierGagnant(char [][] tableau){
        
        // on verifie si qqn a gagné
        for(int i = 0; i < 3; i++){
            if(tableau[i][0] == tableau[i][1] && tableau[i][1] == tableau[i][2] && tableau[i][0] != '-' && tableau[i][0] != 'X'){
                gagnant = '0';
                return gagnant;
            } else if (tableau[i][0] == tableau[i][1] && tableau[i][1] == tableau[i][2] && tableau[i][0] != '-' && tableau[i][0] != '0'){
                gagnant = 'X';
                return gagnant;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (tableau[0][j] == tableau[1][j] && tableau[1][j] == tableau[2][j] && tableau[0][j] != '-' && tableau[0][j] != 'X') {
                gagnant = '0';
                return gagnant;
            } else if (tableau[0][j] == tableau[1][j] && tableau[1][j] == tableau[2][j] && tableau[0][j] != '-' && tableau[0][j] != '0'){
                gagnant = 'X';
                return gagnant;
            }
        }
        
        if (tableau[0][0] == tableau[1][1] && tableau[1][1] == tableau[2][2] && tableau[0][0] != '-' && tableau[0][0] != 'X') {
            gagnant = '0';
            return gagnant;
        } else if(tableau[0][0] == tableau[1][1] && tableau[1][1] == tableau[2][2] && tableau[0][0] != '-' && tableau[0][0] != '0'){
            gagnant = 'X';
            return gagnant;
        }

        if (tableau[2][0] == tableau[1][1] && tableau[1][1] == tableau[0][2] && tableau[2][0] != '-' && tableau[2][0] != 'X') {
            gagnant = '0';
            return gagnant;
        } else if(tableau[2][0] == tableau[1][1] && tableau[1][1] == tableau[0][2] && tableau[2][0] != '-' && tableau[2][0] != '0'){
            gagnant = 'X';
            return gagnant;
        }
        
        int total = 0;
        for(int x=0;x<tableau.length;x++) {
            for(int y=0;y<tableau[x].length;y++){
               if(tableau[x][y] != '-'){
                   total = total + 1;
               }
            } 
        }
        
        if(total == 9){
            gagnant = 'n';
            return gagnant;
        }
        
        return ' ';
    } // Verifier le gagnant
    
    public void afficherJeu(){
        
        // On affiche le jeu
        System.out.println("Le jeu: ");
            for(int i=0;i<tableau.length;i++) {
                
                len = tableau[i].length;
                afficheurTableau[i] = new char[len];
                index = len-1;
                
                for(int j=0;j<tableau[i].length;j++){
                    afficheurTableau[i][j] = tableau[i][index];
                    index--;
                    System.out.print("" + afficheurTableau[i][j] + " "); 
                } 
                System.out.println(""); 
        
            }
        
        
    } // afficher le jeu
    
    public void resoudre(){
        
        boolean encore = true;
        
        while(encore = true){
            
            // Si le joueur est X
            while(joueur == 1){
                afficherJeu();
                verifierGagnant(tableau);
                if(gagnant != ' ' && gagnant != 'n'){
                    System.out.println("joueur" + gagnant + " a gagné");
                    afficherJeu();
                    encore = false;
                    joueur = 0;
                    break;
                } else if (gagnant == 'n'){
                    System.out.println("Partie nulle");
                    afficherJeu();
                    encore = false;
                    joueur = 0;
                    break;
                }
                convertirPosition(0,0);
            }
            
            // Si le joueur est O
            while(joueur == 2){
                afficherJeu();
                verifierGagnant(tableau);
                if(gagnant != ' ' && gagnant != 'n'){
                    afficherJeu();
                    System.out.println("joueur" + gagnant + " a gagné");
                    encore = false;
                    joueur = 0;
                    break;
                } else if (gagnant == 'n'){
                    afficherJeu();
                    System.out.println("Partie nulle");
                    encore = false;
                    joueur = 0;
                    break;
                }
                convertirPosition(0,0);
            }
            
            if(joueur == 0){
                break;
            }

        }
   
   } // resoudre
    
} // class
