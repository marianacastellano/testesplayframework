package controllers;


import java.util.List;
import static play.libs.Json.toJson;
import models.User;
import play.*;
import play.mvc.*;
import views.html.*;
import play.data.Form;
import play.db.ebean.Model;
public class Application extends Controller {

    public static Result index() {
        return ok(index.render("hello people"));
    }
    
    public static Result addUser(){
    	User usuario = Form.form(User.class).bindFromRequest().get();
    	usuario.save();
    	return redirect(routes.Application.index());
    	
    }
	public static Result getUsers(){
    	
		List<User> usuarios = new Model.Finder(String.class, User.class).all();
    	return ok(toJson(usuarios));
    	
    }
    




}
