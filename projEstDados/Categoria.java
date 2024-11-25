package projEstDados;

public class Categoria {
    private String nome;
    private double valor;
    private Categoria[] filhos;  // List of subcategories (branches)
    private int numFilhos;

    // Constructor
    public Categoria(String nome) {
        this.nome = nome;
        this.valor = 0;  // Initial value is 0
        this.filhos = new Categoria[10];  // Maximum of 10 subcategories per category
        this.numFilhos = 0;
    }

    // Add a subcategory (branch)
    public void adicionarFilho(String nomeRamo, double valorRamo) {
        if (numFilhos < filhos.length) {
            Categoria ramo = new Categoria(nomeRamo);
            ramo.setValor(valorRamo);  // Set the branch value
            filhos[numFilhos++] = ramo;
            atualizarValor();  // Update the category value after adding the branch
        } else {
            System.out.println("Limite de ramos atingido para esta categoria.");
        }
    }

    // Update category value based on the sum of all branch values
    public void atualizarValor() {
        this.valor = 0;  // Reset value before recalculating
        for (int i = 0; i < numFilhos; i++) {
            this.valor += filhos[i].getValor();  // Add branch value to the category
        }
    }

    public boolean removerFilho(String nomeRamo) {
        for (int i = 0; i < numFilhos; i++) {
            if (filhos[i].getNome().equalsIgnoreCase(nomeRamo)) {
                filhos[i] = filhos[--numFilhos]; // Shift and decrement
                filhos[numFilhos] = null; // Clear the last element
                atualizarValor(); // Recalculate the total value
                return true;
            }
        }
        return false;
    }

    // Get the category's total value
    public double getValor() {
        return this.valor;
    }

    // Set the value (this will be used for branches)
    public void setValor(double valor) {
        this.valor = valor;
    }

    public Categoria[] getFilhos() {
        return filhos;
    }

    public String getNome() {
        return nome;
    }
}