package util;

public class ResponseJson {

    public boolean sucesso;
    public String mensagem;

    public ResponseJson(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }

}
