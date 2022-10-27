package Application;

import entities.Cliente;
import entities.Pedido;
import entities.PedidoItems;
import entities.Produto;
import entities.enums.OrdemStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre com o nome do cliente: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Data de nascimento: (DD/MM/YYYY)");
        Date dataNascimento = sdf.parse(sc.next());
        Cliente cliente = new Cliente(nome, email, dataNascimento);

        System.out.println("Entre com os dados do pedido: ");
        System.out.print("Status: ");
        OrdemStatus status = OrdemStatus.valueOf(sc.next().toUpperCase());


        Pedido pedido = new Pedido(new Date(), status, cliente);


        System.out.print("Quantos items o pedido vai ter ? ");
        int n = sc.nextInt();
        for (int i = 0; i<n; i++){
            System.out.println("Entre com o pedido: #" + (i +1));
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String nomeProduto = sc.nextLine();
            System.out.print("Preco do produto: ");
            double precoProduto = sc.nextDouble();
            System.out.println("Quantidade: ");
            int quantidade = sc.nextInt();

            Produto produto = new Produto(nomeProduto, precoProduto);
            PedidoItems pedidoItems = new PedidoItems(quantidade, precoProduto, produto);
            pedido.addPedido(pedidoItems);

        }
        System.out.println();
        System.out.println(pedido);
        sc.close();

    }
}
