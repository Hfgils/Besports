/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function CalcularDv()
{
    var arreglo, x, y, z, i, nit1, dv1;
    nit1 = document.Persona.identificacion.value;
//    alert(nit1);
    if (isNaN(nit1))
    {
        document.Persona.dv.value = "X";
        alert('Nï¿½mero del Nit no valido, ingrese un nï¿½mero sin puntos, ni comas, ni guiones, ni espacios');
    } else {
        arreglo = new Array(16);
        x = 0;
        y = 0;
        z = nit1.length;
        arreglo[1] = 3;
        arreglo[2] = 7;
        arreglo[3] = 13;
        arreglo[4] = 17;
        arreglo[5] = 19;
        arreglo[6] = 23;
        arreglo[7] = 29;
        arreglo[8] = 37;
        arreglo[9] = 41;
        arreglo[10] = 43;
        arreglo[11] = 47;
        arreglo[12] = 53;
        arreglo[13] = 59;
        arreglo[14] = 67;
        arreglo[15] = 71;
        for (i = 0; i < z; i++)
        {
            y = (nit1.substr(i, 1));
            x += (y * arreglo[z - i]);
        }
        y = x % 11
        if (y > 1) {
            dv1 = 11 - y;
        } else {
            dv1 = y;
        }
        document.Persona.dv.value = dv1;
    }
}


