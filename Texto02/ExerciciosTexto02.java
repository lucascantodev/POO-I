public class ExerciciosTexto02
{
    public ExerciciosTexto02()
    {
    
    }
    
    public void exercicio2_1()
    {        
        String nome1 = new String("abcdef");
        String nome2 = "ghijklm";
        int tam, comparacao;
        int n1=5, n2=9;
        
        tam = nome1.length();
        //int tam = nome1.length;
        //tam já foi definida, solução seria tirar a segunda declaração.
        //não existe a informação length e sim o comportamento lenght. abrir e fechar parênteses deve funcionar.
        
        comparacao = nome2.compareTo(nome1);
        //comparacao = String.compareTo(nome1);
        //aqui nós estamos comparando um tipo de objeto com outro objeto, o que é errado! é necessário fazer a troca de String por nome2.
        
        String copia = nome2.substring(3,nome2.length()); 
        boolean b1 = nome1.equals("abcdeF");
        
        boolean b2 = nome1.equalsIgnoreCase("GhijkLm");
        //boolena b2 = nome1.equalsIgnoreCase("Ghijklm");
        //o tipo boolena não existe, o certo é boolean.
        
        String s1 = nome1 + nome2 + n1 + n2;
        String s2 = nome1 + nome2 + (n1 + n2);
    }
    
    public int[] exercicio2_2(int num1, int num2) 
    {
        int[] resultado = new int[2];
        if (num1 > num2) {
            resultado[0] = num2;
            resultado[1] = num1;
        } else {
            resultado[0] = num1;
            resultado[1] = num2;
        }
        return resultado;
    }
    
    public float[] exercicio2_3(float num1, float num2, float num3)
    {
        float[] resultadoFinal = new float[3];
        
                
        for (int i=1; i < resultadoFinal.length; i++) {
            if( ( num1 > num2 && num1 > num3 ) && ( num2 > num3 ) ) { // x > y > z
                resultadoFinal[0] = num1;
                resultadoFinal[1] = num2;
                resultadoFinal[2] = num3;
            }
            else if( ( num1 > num2 && num1 > num3 ) && ( num3 > num2 ) ) { // x > z > y
                resultadoFinal[0] = num1;
                resultadoFinal[1] = num3;
                resultadoFinal[2] = num2;
            }   
            else if( ( num2 > num1 && num2 > num3 ) && ( num2 > num3 ) ) { // y > x > z
                resultadoFinal[0] = num2;
                resultadoFinal[1] = num1;
                resultadoFinal[2] = num3;
            }   
            else if( ( num2 > num1 && num2 > num3 ) && ( num3 > num1 ) ) { // y > z > x
                resultadoFinal[0] = num2;
                resultadoFinal[1] = num3;
                resultadoFinal[2] = num1;
            }   
            else if( ( num3 > num1 && num3 > num2 ) && ( num1 > num2 ) ) { // z > x > y
                resultadoFinal[0] = num3;
                resultadoFinal[1] = num1;
                resultadoFinal[2] = num2;
            }   
            else if( ( num3 > num1 && num3 > num2 ) && ( num2 > num1 ) ) { // z > y > x
                resultadoFinal[0] = num3;
                resultadoFinal[1] = num2;
                resultadoFinal[2] = num1;
            }
        }
        return resultadoFinal;
    }
    
    public double exercicio2_4(double raiz)
    {
        return Math.sqrt(raiz);
    }
    
    public boolean exercicio2_5(String primeiraPalavra, String segundaPalavra)
    {
        if (segundaPalavra.indexOf(primeiraPalavra)>-1) {
            return true;
        } else {
            return false;
        }
    }
    
    public String[] exercicio2_6(String primeiraPalavra, String segundaPalavra)
    {   
        if (primeiraPalavra.compareTo(segundaPalavra)<0) {
            return new String[] {primeiraPalavra, segundaPalavra};
        } else {
            return new String[] {segundaPalavra, primeiraPalavra};
        }
    }
    
    public String[] exercicio2_7(String primeira, String segunda, String terceira)
    {
        if (primeira.compareTo(terceira)<0 & primeira.compareTo(terceira)<0) {
            if (segunda.compareTo(terceira)<0) {
                return new String[] {primeira, segunda, terceira};
            }
                return new String[] {primeira, terceira, segunda};
            } else if (segunda.compareTo(primeira)<0 & segunda.compareTo(terceira)<0){
                if (primeira.compareTo(terceira)<0) {
                    return new String[] {segunda, primeira, terceira};
                }
                    return new String[] {segunda, terceira, primeira};
                } else if(terceira.compareTo(primeira)<0 & terceira.compareTo(segunda)<0) {
                    if (primeira.compareTo(segunda)<0) {
                        return new String[] {terceira, primeira, segunda};
                    }
                        return new String[] {terceira, segunda, primeira};
                    }
                    return new String[] {primeira, segunda, terceira};
    }
    
    public String inverterNome (String parametro)
    {
        return parametro.substring(parametro.indexOf(' ')+1, parametro.length()) + ", " + parametro.substring(0, parametro.indexOf(' '));
    }
    
    public String[] exercicio2_8(String[] nomePrimeiro)
    {   
        String[] sobrenomePrimeiro = new String[nomePrimeiro.length];
        
        for (int i=0; i<nomePrimeiro.length; i++){
            sobrenomePrimeiro[i] = inverterNome(nomePrimeiro[i]);
        }
        return sobrenomePrimeiro;
    }
    
    public String[] exercicio2_9(String[] palavra)
    {
        for (int i=0; i<palavra.length; i++) {
            palavra[i] = palavra[i].toUpperCase();
        }
        return palavra;
    }
    
    public String[] exercicio2_10(String[] maiuscula)
    {
        String[] primeiroArray = new String[maiuscula.length];
        
        for (int i=0; i<maiuscula.length; i++){
            primeiroArray[i] = maiuscula[i].toUpperCase();
        }
        return primeiroArray;
    }
    
    public int[] exercicio2_11(int[] numeros)
    {
        int trocarElementos;
        
        for (int i=0; i<numeros.length-1; i++) {
            if (numeros[i]<numeros[i+1]) {
                trocarElementos = numeros[i+1];
                numeros[i+1] = numeros[i];
                numeros[i] = trocarElementos;
            }
        }
        return numeros;
    }
    
    public int exercicio2_12(int[] numeros)
    {
        int trocarElementos;
        int quantidadeDeTrocas = 0;
        
        for (int i=0; i<numeros.length-1; i++) {
            if(numeros[i]<numeros[i+1]){
                trocarElementos = numeros[i+1];
                numeros[i+1] = numeros[i];
                numeros[i] = trocarElementos;
                quantidadeDeTrocas++;
            }
        }
        return quantidadeDeTrocas;
    }
    
    public int exercicio2_13(String[] palavras)
    {
        String trocarElementos;
        int quantidadeDeTrocas = 0;
        
        for (int i=0; i<palavras.length-1; i++) {
            if (palavras[i].compareTo(palavras[i+1])>0) {
                trocarElementos = palavras[i+1];
                palavras[i+1] = palavras[i];
                palavras[i] = trocarElementos;
                quantidadeDeTrocas++;
            }
        }
        return quantidadeDeTrocas;
    }
    
    public String[] exercicio2_13_aux(String[] palavras)
    {
        String trocarElementos;
        int quantidadeDeTrocas = 0;
        for (int i=1; i<palavras.length; i++) {
            trocarElementos = palavras[i+1];
            palavras[i+1] = palavras[i];
            palavras[i] = trocarElementos;
            quantidadeDeTrocas++;
        }
        return palavras;
    }
    
    public int[] exercicio2_14(int[] numeros)
    {
        while (exercicio2_12(numeros)>0) {
            numeros = exercicio2_11(numeros);
        }
        return numeros;
    }
    
    public String[] exercicio2_15(String[] palavras)
    {
        while (exercicio2_13(palavras)>0){
            palavras = exercicio2_13_aux(palavras);
        }
        return palavras;
    }
    
    public String[] ordenarNomes(String[] nomes){
        for(int i=1; i<nomes.length; i++){
            String x = nomes[i];
            int y = i-1;
            while(y>=0 && nomes[y].compareTo(x)>0){
                nomes[y+1] = nomes[y];
                y = y-1;
            }
            nomes[y+1] = x;
        }
        
        return nomes;
    }
    
    public String[] exercicio2_16(String[] nomes)
    {
        String[] nomesInvertidos = exercicio2_8(nomes);
        
        nomes = ordenarNomes(nomesInvertidos);
        
        for (int i=0; i<nomes.length; i++) {
            nomes[i] = nomes[i].substring(nomes[i].indexOf(',')+2, nomes[i].length()) + " " + nomes[i].substring(0, nomes[i].indexOf(','));
        }
        return nomes;
    }
    
    public String[] exercicio2_17(String[] nomes)
    {
        String[] nomesInvertidos = exercicio2_8(nomes);
        
        return ordenarNomes(nomesInvertidos);
    }
}
    
    
    
    
    
    
    
    