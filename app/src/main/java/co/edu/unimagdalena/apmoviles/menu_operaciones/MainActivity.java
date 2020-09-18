package co.edu.unimagdalena.apmoviles.menu_operaciones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText X1, X2, Y1, Y2;
    Button btnPM, btnPen, btnCuadrante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        X1 = findViewById(R.id.editTextX1);
        X2 = findViewById(R.id.editTextX2);
        Y1 = findViewById(R.id.editTextY1);
        Y2 = findViewById(R.id.editTextY2);
        btnPM = findViewById(R.id.buttonPM);
        btnPen = findViewById(R.id.buttonPen);
        btnCuadrante = findViewById(R.id.buttonCuadrante);

        btnPM.setOnClickListener(this);
        btnPen.setOnClickListener(this);
        btnCuadrante.setOnClickListener(this);
    }

    @Override
    public void onClick(@NotNull View v) {
         int x1 = Integer.parseInt(X1.getText().toString());
         int x2 = Integer.parseInt(X2.getText().toString());
         int y1 = Integer.parseInt(Y1.getText().toString());
         int y2 = Integer.parseInt(Y2.getText().toString());

        switch (v.getId()){
            case R.id.buttonPM:
                Toast.makeText(this, "Punto medio = " + pmedio(x1,x2,y1,y2) , Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonPen:
                Toast.makeText(this, "Pendiente = " + pendiente(x1,x2,y1,y2), Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonCuadrante:
                Toast.makeText(this, "("+x1+","+y1+") esta en el"+ cudrante(x1, y1) +
                                            "\n y ("+x2+","+y2+") esta en el"+ cudrante(x2, y2)
                                            , Toast.LENGTH_SHORT).show();
                break;

            default:
                break;

        }
    }

    public String pmedio(int x1, int x2, int y1, int y2){
        int p1, p2;
        p1 = (x1+x2)/2;
        p2 = (y1+y2)/2;

        return "("+p1+","+p2+")";
    }


    public String pendiente(int x1, int x2, int y1, int y2){
        int pendiente;

        if((x2 - x1) == 0){
            return "No es posible hallar la pendiente";
        }

        pendiente = (y2 - y1)/(x2 - x1);
        return "" + pendiente;
    }

    public String cudrante(int pos1, int pos2){
        if(pos1 == 0 && pos2 == 0){
            return "Oringen";
        }

        if(pos1 > 0 && pos2 > 0){
            return "Cuadrante I";
        }

        if(pos1 < 0 && pos2 > 0){
            return "Cuadrante II";
        }

        if(pos1 < 0 && pos2 < 0){
            return "Cuadrante III";
        }

        if(pos1 > 0 && pos2 < 0){
            return "Cuadrante Iv";
        }

        return "error";
    }

    public void aleatorio(){
        Random random = new Random();

        int rand1 = random.nextInt(100) * (random .nextBoolean() ? -1 : 1);
        int rand2 = random.nextInt(100) * (random .nextBoolean() ? -1 : 1);
        int rand3 = random.nextInt(100) * (random .nextBoolean() ? -1 : 1);
        int rand4 = random.nextInt(100) * (random .nextBoolean() ? -1 : 1);

        X1.setText(""+ rand1);
        Y1.setText(""+ rand2);
        X2.setText(""+ rand3);
        Y2.setText(""+ rand4);

    }

    public double distancia(int x1, int x2, int y1, int y2){
        double distancia , potencia1, potencia2;
        potencia1 = Math.pow((x2-x1), 2);
        potencia2 = Math.pow((y2-y1), 2);

        distancia =  Math.sqrt(potencia1 + potencia2);
        return distancia;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int x1 = Integer.parseInt(X1.getText().toString());
        int x2 = Integer.parseInt(X2.getText().toString());
        int y1 = Integer.parseInt(Y1.getText().toString());
        int y2 = Integer.parseInt(Y2.getText().toString());

        switch (item.getItemId()){
            case R.id.m1:
                    aleatorio();
                break;
            case R.id.m2: 
                    Toast.makeText(this,"Distancia entre puntos = \n"+ distancia(x1,x2,y1,y2), Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}