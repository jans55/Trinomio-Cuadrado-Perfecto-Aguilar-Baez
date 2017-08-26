/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binomiotcp;

 //Todas las importaciones
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Aguilar Baez Javier Alejandro y Martínez Barbosa Genaro Enrique, 5IM6
 * @version  1.0 
 * created on 2017/08/25
 */

public class cBinomioTCP extends JFrame implements ActionListener{ //La clase cBinomioTCP se extiende de un JFrame e implementa la interfaz ActionListener
    private JFrame _ventana; //El JFrame
    private JTextField _num1Txt, _num2Txt, _resultadoTxt; //Los campos de texto
    private JButton _calcular, _borrar, _salir; //Botones
    private JLabel _titulo, _subtitulo, _num1Lbl, _num2Lbl, _resultadoLbl;  //Labels  
    private Container _contenedor; //El contenedor del JFrame
    
    public cBinomioTCP () //Constructor
    {
        configVentana(); //Establece las características de la ventana
        muestraComponentes(); //Inicializa todas las variables (botones, cajas de texto y labels)
        this._ventana.setVisible(true); //Hace visible la ventana
    }
    
    public void configVentana()
    {
        _ventana = new JFrame();
        _ventana.setSize(800, 650); //Tamaño
        _ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _ventana.setLocationRelativeTo(null); //Centrada
        _ventana.setLayout(null);
        _ventana.setResizable(false); //No redimensionable
        _contenedor = _ventana.getContentPane();  
        _contenedor.setBackground(Color.cyan);
    }
    
    public void muestraComponentes()
    {
        _calcular = new JButton("Calcular"); //Botón con el que se obtiene el TCP a partir de ambos términos
        _calcular.setBounds(550, 380, 150, 80);  
        _calcular.setBackground(Color.GREEN);
        _calcular.setForeground(Color.BLUE);
        _calcular.setFont(new Font("Tahoma", 1, 24));
        _contenedor.add(_calcular);
        _calcular.addActionListener(this);
        _calcular.setVisible(true);   
        
        _borrar = new JButton("Borrar"); //Borra los campos de texto
        _borrar.setBounds(400, 530, 150, 60);  
        _borrar.setBackground(Color.ORANGE);
        _borrar.setForeground(Color.RED);
        _borrar.setFont(new Font("Calibri", 1, 20));
        _contenedor.add(_borrar);
        _borrar.addActionListener(this);
        _borrar.setVisible(true);
        
        _salir = new JButton("Salir"); //Salir del programa
        _salir.setBounds(600, 530, 150, 60);  
        _salir.setBackground(Color.RED);
        _salir.setForeground(Color.WHITE);
        _salir.setFont(new Font("Calibri", 1, 20));
        _contenedor.add(_salir);
        _salir.addActionListener(this);
        _salir.setVisible(true);
        
        _num1Txt = new JTextField(); //Caja de texto para ingresar el primer término del binomio
        _num1Txt.setBounds(200, 220, 150, 30);
        _contenedor.add(_num1Txt);
        _num1Txt.setVisible(true);
        
        _num2Txt = new JTextField(); //Caja de texto para ingresar el segundo término del binomio
        _num2Txt.setBounds(200, 280, 150, 30);
        _contenedor.add(_num2Txt);
        _num2Txt.setVisible(true);
        
        _resultadoTxt = new JTextField(); //Caja de texto para desplegar el Trinomio
        _resultadoTxt.setBounds(200, 400, 300, 30);
        _contenedor.add(_resultadoTxt);
        _resultadoTxt.setVisible(true);
        _resultadoTxt.setEditable(false);
        
        _titulo = new JLabel("Calcular Trinomio Cuadrado Perfecto"); //El título
        _titulo.setBounds(100, 50, 700, 50);
        _titulo.setFont(new Font("Georgia", 1, 32));
        _titulo.setForeground(Color.RED);
        _contenedor.add(_titulo);
        _titulo.setVisible(true);
        
        _subtitulo = new JLabel("Ingrese los dos términos del binomio para calcular el TCP."); //Instrucciones del programa
        _subtitulo.setBounds(100, 130, 500, 50);
        _subtitulo.setFont(new Font("Century Gothic", 1, 14));
        _subtitulo.setForeground(Color.black);
        _contenedor.add(_subtitulo);
        _subtitulo.setVisible(true);
        
        _num1Lbl = new JLabel("Término 1:");
        _num1Lbl.setBounds(100, 220, 100, 30);
        _num1Lbl.setFont(new Font("Verdana", 1, 12));
        _num1Lbl.setForeground(Color.black);
        _contenedor.add(_num1Lbl);
        _num1Lbl.setVisible(true);
        
        _num2Lbl = new JLabel("Término 2:");
        _num2Lbl.setBounds(100, 280, 100, 30);
        _num2Lbl.setFont(new Font("Verdana", 1, 12));
        _num2Lbl.setForeground(Color.black);
        _contenedor.add(_num2Lbl);
        _num2Lbl.setVisible(true);
        
        _resultadoLbl = new JLabel("Resultado:");
        _resultadoLbl.setBounds(100, 400, 100, 30);
        _resultadoLbl.setFont(new Font("Verdana", 1, 12));
        _resultadoLbl.setForeground(Color.black);
        _contenedor.add(_resultadoLbl);
        _resultadoLbl.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == _calcular) //Si se oprime el botón de calcular
        {
            if (!_num1Txt.getText().isEmpty() && !_num2Txt.getText().isEmpty()) //Valida que ambos campos de texto no estén vacíos
            {
                try
                {
                    String primerT, segundoT, tercerT, resultado; //Variables que guardarán los tres términos del TCP, y el resultado final                
                    String primerB = _num1Txt.getText(); //Toma el primer término del binomio
                    String segundoB = _num2Txt.getText(); //Toma el segundo término del binomio                    
                    if (!primerB.equals("0") && !primerB.equals("0x") && !primerB.equals("0y") && !primerB.equals("0xy") && !segundoB.equals("0") && !segundoB.equals("0x") && !segundoB.equals("0y") && !segundoB.equals("0xy"))
                    {
                        //Calcular Primer Término del TCP
                        
                        boolean negativo = false; //Booleano que verificará si el segundo término es negativo o no
                        String num1 = ""; //Variable que obtendrá TODO el número del primer término del TCP
                        String variables1 = ""; //Guardará las literales del primer término del TCP
                        for (int i = 0; i<primerB.length(); i++) //Recorre la cadena del primer término del binomio
                        {
                            if (primerB.charAt(i) == '0' || primerB.charAt(i) == '1' || primerB.charAt(i) == '2' || primerB.charAt(i) == '3' || primerB.charAt(i) == '4' || primerB.charAt(i) == '5' || primerB.charAt(i) == '6' || primerB.charAt(i) == '7' || primerB.charAt(i) == '8' || primerB.charAt(i) == '9')                            
                                num1 += primerB.charAt(i); //Si es un número, se concatena con la variable del número 1                            
                            else
                            {
                                if (primerB.charAt(i) != '+' && primerB.charAt(i) != '-')                                    
                                    variables1 += primerB.charAt(i) + "^2 "; //Si no es número ni signo, se guarda en la variable de literales, y se eleva al cuadrado de una vez                                                                
                                else
                                {
                                    if (primerB.charAt(i) == '-') //Si el signo es un menos, se cambia el estado de la variable booleana
                                    {                                        
                                        if (negativo == false)                                        
                                            negativo = true;                                                     
                                        else                                        
                                            negativo = false;                                        
                                    }
                                }
                            }
                        }
                        if (!num1.equals("")) //Si existe un valor numérico, se eleva al cuadrado
                            num1 = String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num1)); //Se eleva al cuadrado TODO el número                        
                        primerT = num1 + variables1; //Ahora sí, se concatena el número al cuadrado con todas las variables al cuadrado, y se guarda como el primer término del TCP

                        //Calcular Segundo Término del TCP

                        String num2 = ""; //Variable que guardará TODO el número del segundo término del TCP
                        String num2a = ""; //Esta variable guardará el número del primer término del binomio, para luego ser sumada con la del segundo
                        String num2b = ""; //Esta es la segunda variable de lo explicado en la línea de arriba
                        String variables2 = ""; //Guardará las literales del segundo término del TCP                        
                        for (int i = 0; i<primerB.length(); i++)
                        {
                            if (primerB.charAt(i) == '0' || primerB.charAt(i) == '1' || primerB.charAt(i) == '2' || primerB.charAt(i) == '3' || primerB.charAt(i) == '4' || primerB.charAt(i) == '5' || primerB.charAt(i) == '6' || primerB.charAt(i) == '7' || primerB.charAt(i) == '8' || primerB.charAt(i) == '9')                                                        
                                num2a += primerB.charAt(i); //Si es un número, se concatena con la primer variable del número 2                                                        
                            else
                            {
                                if (primerB.charAt(i) != '+' && primerB.charAt(i) != '-')                                 
                                    variables2 += primerB.charAt(i); //Si es letra, se concatena con las literales                                
                            }
                        }
                        for (int i = 0; i<segundoB.length(); i++)
                        {
                            if (segundoB.charAt(i) == '0' || segundoB.charAt(i) == '1' || segundoB.charAt(i) == '2' || segundoB.charAt(i) == '3' || segundoB.charAt(i) == '4' || segundoB.charAt(i) == '5' || segundoB.charAt(i) == '6' || segundoB.charAt(i) == '7' || segundoB.charAt(i) == '8' || segundoB.charAt(i) == '9')                            
                                num2b += segundoB.charAt(i); //Si es un número, se concatena con la segunda variable del número 2                            
                            else
                            {
                                if (segundoB.charAt(i) != '+' && segundoB.charAt(i) != '-')                                                                
                                    variables2 += segundoB.charAt(i); //Si no, se concatena con letras                                                      
                            }
                        }
                        if (num2a.equals("") || num2b.equals("")) //Valida que no falte el número en un término (el cual, por convención, es 1)
                        {
                            if (!num2a.equals("") && num2b.equals("")) //Sólo el primer término se multiplica por dos, pues el segundo es uno (no está escrito)                
                                num2 = String.valueOf(Integer.parseInt(num2a)*2);                            
                            else
                            {
                                if (num2a.equals("") && !num2b.equals("")) //Sólo se duplica el segundo término (el primero es uno, y no se escribe)
                                    num2 = String.valueOf(Integer.parseInt(num2b)*2);
                                else
                                {  
                                    if (num2a.equals("") && num2b.equals("")) //Si ningún término tiene número, automáticamente se escribe un "2" (es decir, doble producto)                                 
                                        num2 = "2";                                                        
                                }
                            }
                        }
                        else                        
                            num2 = String.valueOf(2*(Integer.parseInt(num2a))*(Integer.parseInt(num2b))); //Si ambos números están especificados, se multiplican y se duplica el resultado
                        segundoT = num2 + variables2; //Se concatena el número con las variables, resultado se guarda como el segundo término del trinomio

                        //Calcular Tercer Término del TCP

                        String num3 = ""; //Variable que obtendrá TODO el número del tercer término del TCP
                        String variables3 = ""; //Guardará las literales del tercer término del TCP
                        for (int i = 0; i<segundoB.length(); i++) //Recorre la cadena del segundo término del binomio
                        {
                            if (segundoB.charAt(i) == '0' || segundoB.charAt(i) == '1' || segundoB.charAt(i) == '2' || segundoB.charAt(i) == '3' || segundoB.charAt(i) == '4' || segundoB.charAt(i) == '5' || segundoB.charAt(i) == '6' || segundoB.charAt(i) == '7' || segundoB.charAt(i) == '8' || segundoB.charAt(i) == '9')                            
                                num3 += segundoB.charAt(i); //Si es un número, se concatena con la variable del número 3                            
                            else
                            {
                                if (segundoB.charAt(i) != '+' && segundoB.charAt(i) != '-')                                
                                    variables3 += segundoB.charAt(i) + "^2 "; //Si no es número ni signo, se guarda en la variable de literales, y se eleva al cuadrado de una vez                                
                                else
                                {
                                    if (segundoB.charAt(i) == '-') //Si el signo es un menos, se cambia el estado de la variable booleana
                                    {                                        
                                        if (negativo == false)                                        
                                            negativo = true;                                                     
                                        else                                        
                                            negativo = false;                                        
                                    }
                                }
                            }
                        }
                        if (!num3.equals(""))                        
                            num3 = String.valueOf(Integer.parseInt(num3) * Integer.parseInt(num3)); //Se eleva al cuadrado TODO el número                        
                        tercerT = num3 + variables3; //Ahora sí, se concatena el número al cuadrado con todas las variables al cuadrado, y se guarda como el tercer término del TCP
                        if (negativo == false) //El booleano sirvió para especificar el signo del segundo término
                            resultado = primerT + " + " + segundoT + " + " + tercerT; //Si el booleano NO es negativo, el signo del segundo término es positivo                      
                        else                        
                            resultado = primerT + " - " + segundoT + " + " + tercerT; //Si el booleano SÍ es negativo, el signo del segundo término es negativo                       
                        _resultadoTxt.setText(resultado); //Se despliega el resultado final en el cuadro de texto
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Los valores ingresados no pueden ser cero.");
                        _num1Txt.setText(null);
                        _num2Txt.setText(null);
                        _resultadoTxt.setText(null);
                    }
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(this, "Ingresa datos apropiados.");
                    _num1Txt.setText(null);
                    _num2Txt.setText(null);
                    _resultadoTxt.setText(null);
                }
            }
            else            
                JOptionPane.showMessageDialog(this, "Ingresa ambos términos.");                       
        }
        else
        {
            if (e.getSource() == _borrar)
            {
                if (!_num1Txt.getText().isEmpty() || !_num2Txt.getText().isEmpty() || !_resultadoTxt.getText().isEmpty()) //Borra lo escrito, sólo si hay algo escrito
                {
                    _num1Txt.setText(null);
                    _num2Txt.setText(null);
                    _resultadoTxt.setText(null);
                }
                else                
                    JOptionPane.showMessageDialog(this, "¿¡Qué quieres borrar!?");                
            } 
            else
            {
                if (e.getSource() == _salir)
                {
                    JOptionPane.showMessageDialog(this, "¡Gracias por usar este programa!");
                    System.exit(0);
                }
            }
        }
    }
}
