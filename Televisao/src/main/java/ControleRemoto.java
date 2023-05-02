import java.util.InputMismatchException;
import java.util.Scanner;

public class ControleRemoto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Lista lista=new Lista();

        lista.inserir(new Canal("Globo"));
        lista.inserir(new Canal("Record"));
        lista.inserir(new Canal("SBT"));
        lista.inserir(new Canal("Cultura"));
        lista.inserir(new Canal("Band"));

        Televisao tv = new Televisao(50,1);

        int comando;

        do {
            System.out.println("LF TV!\n" +
                    "Volume: " + tv.getVolume() + "\tCanal: " + tv.getCanal() + " - " + lista.pesquisarID(tv.getCanal())[3]);
            System.out.println("\n=====\n" +
                    "0- Desligar TV\n" +
                    "1- Aumentar Volume\n" +
                    "2- Diminuir Volume\n" +
                    "3- Aumentar Canal\n" +
                    "4- Diminuir Canal\n" +
                    "5- Lista de Canais\n" +
                    "=====");

            comando= sc.nextInt();

            switch(comando) {

                case 0:
                    System.out.println("Tchau!");
                    break;
                case 1:
                    if (tv.getVolume() < 100) {
                        tv.setVolume(tv.getVolume()+1);
                    }
                    break;
                case 2:
                    if (tv.getVolume() > 0) {
                        tv.setVolume(tv.getVolume()-1);
                    }
                    break;
                case 3:
                    if (tv.getCanal() < lista.contador()) {
                        tv.setCanal(tv.getCanal()+1);
                    }
                    break;
                case 4:
                    if (tv.getCanal() > 1) {
                        tv.setCanal(tv.getCanal()-1);
                    }
                    break;

                case 5:
                    lista.exibir();
                    int novoCanal = selecionarCanal(tv,lista);
                    while (novoCanal==0){
                        novoCanal=selecionarCanal(tv,lista);
                    }
                    tv.setCanal(novoCanal);
                    break;

                default:
                    System.out.println("Valor inválido\n=====");
            }
        } while(comando != 0);

        sc.close();

    }

    public static int selecionarCanal(Televisao tv, Lista lista){

        Scanner sc = new Scanner(System.in);
        int confirma=0;

    do {
        System.out.println("Deseja selecionar um canal?\n" +
                " \"s\" - sim\n " +
                "\"n\" - não");

        char escolha = sc.next().toLowerCase().charAt(0);

        switch (escolha) {

            case 's':
                int verifica = 1;
                do {

                    lista.exibir();

                    System.out.println("\nSelecione um canal:");

                    int canal;

                    try {
                        canal = sc.nextInt();

                        if (lista.pesquisarID(canal) == null) {
                            System.out.println("Canal inexistente!");
                        } else {
                            System.out.println("\nCanal selecionado: " + lista.pesquisarID(canal)[2] + "\n");
                            verifica = 0;
                            return canal;
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida!");
                        sc.nextLine();
                    }

                } while (verifica == 1);
                confirma=1;
                break;

            case 'n':
                confirma=1;
                break;

            default:
                System.out.println("Valor inválido");
                break;
        }
    }while (confirma==0);
        return tv.getCanal();
    }

}
