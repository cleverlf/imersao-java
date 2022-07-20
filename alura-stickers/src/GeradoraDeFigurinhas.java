import java.awt.Color;
import java.awt.Font;
<<<<<<< HEAD
=======
import java.awt.FontMetrics;
>>>>>>> c44b444c3cf92357e0259649ce23ddb4db032ce7
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura da imagem
        // InputStream inputStream =
        // new FileInputStream(new File("entrada/filme-maior.jpg"));
        // InputStream inputStream =
        // new
        // URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
        // .openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
<<<<<<< HEAD
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
=======
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.OPAQUE);
>>>>>>> c44b444c3cf92357e0259649ce23ddb4db032ce7

        // copiar a imagem original pra novo imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
<<<<<<< HEAD
        var fonte = new Font("Impact", Font.BOLD, (largura / 15));
        graphics.setColor(Color.GREEN);
        graphics.setFont(fonte);

        
        // escrever uma frase na nova imagem
        String texto = "TOPZERA";
        graphics.drawString(texto, (largura / 12), novaAltura-100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("alura-stickers/figurinhas/" + nomeArquivo));
=======
        var fonte = new Font("Impact", Font.BOLD, 64);
        graphics.setColor(Color.GREEN);
        graphics.setFont(fonte);

        String texto = "TOPZERA";
        // escrever uma frase na nova imagem

        graphics.drawString(texto, 100, novaAltura-100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "jpg", new File("alura-stickers/figurinhas/" + nomeArquivo));
>>>>>>> c44b444c3cf92357e0259649ce23ddb4db032ce7

    }

}
