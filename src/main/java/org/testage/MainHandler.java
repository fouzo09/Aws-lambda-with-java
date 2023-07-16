package org.testage;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class MainHandler implements RequestHandler<String, String> {
   @Override
    public String handleRequest(String age, Context context){

       if(age == null){
           return "L'age donnée est incorrecte";
       }

       try {
            int givingAge = Integer.parseInt(age);
            if(givingAge <= 3){
                return "C'est un bebe";
            }else if(givingAge <= 17){
                return "C'est un enfant";
            }else if(givingAge <= 22){
                return "C'est un adolescent";
            }else if(givingAge <= 25){
                return "C'est un jeune";
            }else if(givingAge <= 45){
                return "C'est un adulte";
            }else{
                return "C'est un vieux";
            }
       }catch (NumberFormatException ex){
           context.getLogger().log(ex.toString());
            return ex.getMessage();
       }
    }
}