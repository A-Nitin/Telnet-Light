/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileTransfer;

/**
 *
 * @author Nitin.A
 */
public class MyFile {
    private int id;
    private String name;
    private byte[] data;
    private String fileExtension;
    
    public MyFile(int id,String name,byte[] data,String fileExtension){
        this.id =id;
        this.name=name;
        this.data = data;
        this.fileExtension = fileExtension;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setData(byte[] data){
        this.data = data;
    }
    
    public void setFileExtension(String fileExtension){
        this.fileExtension = fileExtension;
    }
    
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public byte[] getData(){
        return data;
    }
    public String getFileExtension(){
        return fileExtension;
    }
}
