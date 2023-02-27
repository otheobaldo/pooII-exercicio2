import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InspecaoClasses {   
    public static void main(String[] args){
        String classe = "Disciplina";
         
        try{
            // Carrega a classe desejada
            Class<?> clazz = Class.forName(classe);

            getConstrutor(clazz);
            getMetodos(clazz);            
            getAtributos(clazz);
            System.out.print("\n");
            imprimirHierarquia(clazz, 0);
        }   
        catch(ClassNotFoundException e){
            System.out.println("Classe não encontrada: "+e.getMessage());
        } 
    }

    private static void getMetodos(Class<?> clazz){ 
        // Obtém os métodos da classe
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("\nMétodos:");
        
        // Itera sobre os métodos e imprime seus nomes
        for (Method method : methods) {
            System.out.println("  |" + method.getName() + "     Quantidade de Parâmetros: " + method.getParameterCount());
        }            
    }

    private static void getConstrutor(Class<?> clazz){
        // Obtém os construtores da classe
        Constructor<?> construtor = clazz.getDeclaredConstructors()[0];
        System.out.println("\nConstrutor: \n |" + construtor.getName() + "      Quantidade de Parâmetros: " + construtor.getParameterCount());
    }

    private static void getAtributos(Class<?> clazz){
        // Obtém os atributos da classe
        Field[] campos = clazz.getDeclaredFields();
        System.out.println("\nAtributos:");
        
        // Itera sobre os atributos e imprime seus nomes
        for (Field field : campos) {
            System.out.println("  |" + field.getName());
        }
    }

    private static void invocarMetodo(Class<?> clazz, String metodo, Object obj, Object arg){
        Method m;
        try {
			m = acharMetodoPeloNome(clazz, metodo);
			m.invoke(obj, arg);
		} catch (Exception e) {
			e.printStackTrace();
		}		
    }

    public static Method acharMetodoPeloNome(Class<?> c, String nome) throws Exception {
		for (Method m : c.getMethods()) {
			if (m.getName().equals(nome)) {
				return m;
			}
		}
		throw new Exception("Método " + nome + " não encontrado");
	}

    private static void imprimirHierarquia(Class<?> clazz, int nivel) {
		List<Class<?>> lista = getSuperclasseEInterfaces(clazz);
		String recuo = "";
		for (int i = 0; i < nivel; i++) { recuo += "   "; }
        for (Class<?> c : lista) {
			System.out.print(recuo + "|-> " + c.getName());
			if (!c.isInterface()) { 
				System.out.print(" (superclass)");
			}
			System.out.println(" ");
			if (c != Object.class) {
				imprimirHierarquia(c, nivel+1);
			}
		}
	}
	
	private static List<Class<?>> getSuperclasseEInterfaces(Class<?> clazz) {
		List<Class<?>> lista = new ArrayList<>();
		if (clazz.getSuperclass() != null) {
			lista.add(clazz.getSuperclass());
		}
		lista.addAll(Arrays.asList(clazz.getInterfaces()));
		return lista;
	}

    // public static void getAnotacao(Class<?> clazz, String x) {
    //     if(clazz.isAnnotationPresent(x.class)){
    //         Annotation[] anotacao = clazz.getAnnotations();
    //         System.out.println("\nAnotações:");
            
    //         // Itera sobre os atributos e imprime seus nomes
    //         for (Annotation annotation : anotacao) {
    //             System.out.println("  |" + anotacao);
    //         }
    //     }
    //     else{
    //         System.out.println("Não tem anotação");
    //     }
    
    // }

}