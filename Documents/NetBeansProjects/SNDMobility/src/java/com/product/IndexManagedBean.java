/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Avin
 */






@ManagedBean(name="indexManagedBean")
@SessionScoped
public class IndexManagedBean {

private StreamedContent imagemEnviada = new DefaultStreamedContent();  
private String imagemTemporaria;
private CroppedImage croppedImage;
private boolean exibeBotao = false;


 public StreamedContent getImagemEnviada() {
        return imagemEnviada;
    }

    public void setImagemEnviada(StreamedContent imagemEnviada) {
        this.imagemEnviada = imagemEnviada;
    }

    public String getImagemTemporaria() {
        return imagemTemporaria;
    }

    public void setImagemTemporaria(String imagemTemporaria) {
        this.imagemTemporaria = imagemTemporaria;
    }

    public CroppedImage getCroppedImage() {
        return croppedImage;
    }

    public void setCroppedImage(CroppedImage croppedImage) {
        this.croppedImage = croppedImage;
    }



    public boolean isExibeBotao() {
        return exibeBotao;
    }

/* getters e setters */

   public void criaArquivo(byte[] bytes, String arquivo) throws IOException {
      FileOutputStream fos;
      try {
         fos = new FileOutputStream(arquivo);
         fos.write(bytes);
         fos.close();
      } catch (FileNotFoundException ex) {
         Logger.getLogger(IndexManagedBean.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
         Logger.getLogger(IndexManagedBean.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public void enviarImagem(FileUploadEvent event) throws IOException {
      byte[] img = event.getFile().getContents();
      imagemTemporaria = event.getFile().getFileName();
      FacesContext facesContext = FacesContext.getCurrentInstance();
      ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
      String arquivo = scontext.getRealPath("/upload/" + imagemTemporaria);
      criaArquivo(img, arquivo);
      setExibeBotao(true);
   }

   public void crop() {
      setImagemEnviada(new DefaultStreamedContent(new ByteArrayInputStream(croppedImage.getBytes())));
   }

    private void setExibeBotao(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
