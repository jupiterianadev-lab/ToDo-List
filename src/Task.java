import java.time.LocalDate;

public class Task {

    private String titulo;
    private String descricao;
    private LocalDate dataEntrega;
    private boolean concluida;

    public Task(String titulo, String descricao, LocalDate dataEntrega) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.concluida = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public String toString() {
        String status = concluida ? "Concluída ✅" : "Pendente ⌛";
        return "\n____________________________________" +
                "\nTítulo: " + titulo +
                "\nDescrição: " + descricao +
                "\nData de Entrega: " + dataEntrega +
                "\nStatus: " + status +
                "\n____________________________________";
    }
}

