/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Avin
 */
@ManagedBean
@SessionScoped
public class FileUploadControl implements Serializable{

   private String dest="C:\\tmp\\";
   private UploadedFile file;

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    
    public FileUploadControl() {
    }
    
    
    public void TransferFile(String fileName, InputStream in) throws FileNotFoundException
    {
        try{
            OutputStream out=new FileOutputStream(new File(dest + fileName));
            int reader=0;
            byte[] bytes=new byte[(int)getFile().getSize()];
            while((reader=in.read(bytes)) != -1)
            {
                out.write(bytes,0,reader);
            }
            in.close();
            out.flush();
            out.close();
        }
        catch(IOException e)
        {
            System.out.println("exceppppption" +e.getMessage());
        }
            
    }
    
    
    public void upload()
    {
        String extValidate;
        if(getFile()!=null)
        {
            String ext=getFile().getFileName();
            if(ext!=null)
            {
                extValidate=ext.substring(ext.indexOf(".")+1);
            }
            else
            {
                extValidate="null";
            }
            
            if(extValidate.equals("jpg"))
            {
                try
                {
                    TransferFile(getFile().getFileName(), getFile().getInputstream());
                }
                catch(IOException ex)
                {
                     //   Logger.getLogger(FileUploadControl.class.getName()).log(Level.SEVERE,null,ex);
                        FacesContext context=FacesContext.getCurrentInstance();
                        context.addMessage(null, new FacesMessage("Wrong","Error Uploadin Files"));
                }
                         FacesContext context=FacesContext.getCurrentInstance();
                         context.addMessage(null,new FacesMessage("Successful", getFile().getFileName()+"is uploaded.TypeContent"+getFile().getContentType()+"Size"+getFile().getSize()));
            }
            else
            {
                FacesContext context= FacesContext.getCurrentInstance();
                context.addMessage(null,new FacesMessage("Wrong ext", "only .jpg extension"));
            }
            
            
        }
        else
        {
            FacesContext context= FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Wrong","Select a file"));
        }
    }
    
    
}
