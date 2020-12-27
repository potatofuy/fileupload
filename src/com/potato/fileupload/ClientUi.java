package com.potato.fileupload;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class ClientUi extends JFrame {
    private JPanel contentPane;	//声明一个 JFileChooser 对象
    private JFileChooser chooser;
    File fi;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientUi frame = new ClientUi();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ClientUi() {
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());   //	将窗体JFrame的 LookAndFeel 设定为 Windows
        } catch (UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }

        //将 chooser 实例化
        chooser=new JFileChooser();

//        FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                "EXCEL文件(*xls)", "xls");
//        chooser.setFileFilter(filter);//增加文件过滤器
        String defaultFileName="侬好呀"+" .xls";;
        chooser.setSelectedFile(new File(defaultFileName)); //设置默认文件名


        //定义窗体
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnOpenFile = new JButton("保存文件");
        btnOpenFile.setFocusable(false);
        btnOpenFile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                /**
                 * 弹出一个打开文件的对话框 showOpenDialog()
                 * 需要指定一个父级窗体，或指定为 null
                 * 返回值是 int 类型，创建以接收返回值
                 */

                int value=chooser.showSaveDialog(ClientUi.this);
                chooser.setDialogTitle("保存文件");
                chooser.setMultiSelectionEnabled(true);


                if (value==chooser.APPROVE_OPTION) {
                    /*
                     * 创建一个文件对象，接收返回值	getSelectedFile()只能返回选中文件中的第一个文件，
                     *  File file=chooser.getSelectedFile()
                     * System.out.println(file.getAbsolutePath());getSelectedFiles() 返回所有选中的文件0
                     */
                    //显示保存的路径
                    File filex[]=chooser.getSelectedFiles();
                    for (int i = 0; i < filex.length; i++) {
                        System.out.println(filex[i].getAbsolutePath());
                        fi = chooser.getSelectedFile();
                        String f = fi.getAbsolutePath()+" .xls";
                        System.out.println("save: "+f);
                    }
                }
            }
        });

        contentPane.add(btnOpenFile);

        JButton btnOpenDir = new JButton("打开文件");
        btnOpenDir.setFocusable(false);
        btnOpenDir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                //设定当前可选择的文件类型，设定为 DIRECTORIES_ONLY，即只能选择文件如果没有设定，
                //默认为 FILES_ONLY，即只能选择文件
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                //将chooser 设定为可多选,如果没有设定，默认为 false，即只能单选
                chooser.setMultiSelectionEnabled(true);
                int value=chooser.showOpenDialog(ClientUi.this);
                if (value==chooser.APPROVE_OPTION) {
                    // 创建一个文件对象，接收返回值
                    // getSelectedFile()只能返回选中文件夹中的第一个文件夹
                    // File dir=chooser.getSelectedFile();
                    // System.out.println(dir.getAbsolutePath());
                    //getSelectedFiles() 返回所有选中的文件夹

                    File dirx[]=chooser.getSelectedFiles();

                    for (int i = 0; i < dirx.length; i++) {

                        System.out.println(dirx[i].getAbsolutePath());

                    }

                }

            }

        });

        contentPane.add(btnOpenDir);
    }
}