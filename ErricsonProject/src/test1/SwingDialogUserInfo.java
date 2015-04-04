package test1;

import com.jcraft.jsch.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class SwingDialogUserInfo implements UserInfo, UIKeyboardInteractive{
    
  public boolean promptYesNo(String str){
    Object[] options={ "yes", "no" };
    int foo=JOptionPane.showOptionDialog(null,
                                         str,
                                         "Warning",
                                         JOptionPane.DEFAULT_OPTION,
                                         JOptionPane.WARNING_MESSAGE,
                                         null, options, options[0]);
    return foo==0;
  }

  private String passphrase;

  public String getPassphrase(){ return passphrase; }
  
  public boolean promptPassphrase(String message){
    this.passphrase = promptPassImpl(message);
    return passphrase != null;
  }

  private String passwd;
  
  public String getPassword(){ return passwd; }

  public boolean promptPassword(String message){
    this.passwd = promptPassImpl(message);
    return passwd != null;
  }
  
  private String promptPassImpl(String message) {
    JTextField passwordField = new JPasswordField(20);
    Object[] ob={passwordField};
    int result=
      JOptionPane.showConfirmDialog(null, ob, message,
                                    JOptionPane.OK_CANCEL_OPTION);
    if(result==JOptionPane.OK_OPTION){
      String pwd = passwordField.getText();
      passwordField.setText("");
      return pwd;
    }
    else{
      passwordField.setText("");
      return null;
    }
  }
  
  public void showMessage(String message){
    JOptionPane.showMessageDialog(null, message);
  }

  private final GridBagConstraints gbc =
    new GridBagConstraints(0,0,1,1,1,1,
                           GridBagConstraints.NORTHWEST,
                           GridBagConstraints.NONE,
                           new Insets(0,0,0,0),0,0);
  private Container panel;
  
  public String[] promptKeyboardInteractive(String destination,
                                            String name,
                                            String instruction,
                                            String[] prompt,
                                            boolean[] echo){
    panel = new JPanel();
    panel.setLayout(new GridBagLayout());

    gbc.weightx = 1.0;
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.gridx = 0;
    panel.add(new JLabel(instruction), gbc);
    gbc.gridy++;

    gbc.gridwidth = GridBagConstraints.RELATIVE;

    JTextField[] texts=new JTextField[prompt.length];
    for(int i=0; i<prompt.length; i++){
      gbc.fill = GridBagConstraints.NONE;
      gbc.gridx = 0;
      gbc.weightx = 1;
      panel.add(new JLabel(prompt[i]),gbc);

      gbc.gridx = 1;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.weighty = 1;
      if(echo[i]){
        texts[i]=new JTextField(20);
      }
      else{
        texts[i]=new JPasswordField(20);
      }
      panel.add(texts[i], gbc);
      gbc.gridy++;
    }

    if(JOptionPane.showConfirmDialog(null, panel,
                                     destination+": "+name,
                                     JOptionPane.OK_CANCEL_OPTION,
                                     JOptionPane.QUESTION_MESSAGE)
       ==JOptionPane.OK_OPTION){
      String[] response=new String[prompt.length];
      for(int i=0; i<prompt.length; i++){
        response[i]=texts[i].getText();
      }
      return response;
    }
    else{
      return null; 
    }
  }
}
