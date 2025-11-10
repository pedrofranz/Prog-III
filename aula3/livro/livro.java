package livro;
public class livro {
    private String titulo;
    private String autor;

    public livro(){

    }

    public livro(String titulo, String autor) {
        super();
        this.titulo = titulo;
        this.autor = autor;

    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public static void main(String[] args) {
        livro l1 = new livro();
        l1.setAutor("Ronaldinho Gaúcho");
        l1.setTitulo("As tranças da vovó careca");

        livro l2 = new livro("Poeira em auto mar", "Arrascaeta");

        System.out.println("autor: " + l1.getAutor() + " titulo: " + l1.getTitulo());
        System.out.println("autor: " + l2.getAutor() + " titulo: " + l2.getTitulo());
    }
}
