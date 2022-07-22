import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = 400;
        int altura = (imagemOriginal.getHeight() * largura) / imagemOriginal.getWidth();
        int novaAltura = altura + 50;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original pra novo imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, largura , altura, null);

        // configurar a fonte e escrever uma frase na nova imagem
        String texto = "TOPZERA";
        var fonte = new Font("Impact", Font.BOLD, 37);
        
        TextLayout textLayout = new TextLayout(texto, fonte, graphics.getFontRenderContext());
        Shape shape = textLayout.getOutline(null);

        graphics.setColor(Color.BLACK);
        graphics.setFont(fonte);

        FontMetrics phraseSize = graphics.getFontMetrics(fonte);

        float x = ((float)(novaImagem.getWidth() / 2) - ((float) phraseSize.stringWidth(texto)) / 2);
        int y = novaImagem.getHeight() - 10;

        graphics.translate(x, y);
        graphics.setStroke(new BasicStroke(4));
        graphics.setColor(Color.BLACK);
        graphics.draw(shape);
        graphics.setColor(Color.GREEN);
        graphics.fill(shape);

        // escrever a nova imagem em um arquivo
        
        ImageIO.write(novaImagem, "png", new File("alura-stickers/figurinhas/" + nomeArquivo));

    }

}
