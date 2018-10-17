
import * as React from "react";

export class SignUpForm extends React.Component{
    render (){
        return(
            <form>
                <div>
                    <label>Name:</label>
                    <input type="text"/>
                </div>
                <div>
                    <label>Surname:</label>
                    <input type="text"/>
                </div>
                <div>
                    <label>Email:</label>
                    <input type="text"/>
                </div>
                <div>
                    <label>Password:</label>
                    <input type="text"/>
                </div>
                <div>
                    <label>Repeat password:</label>
                    <input type="text"/>
                </div>
                <button className="btn btn-primary">Save</button>
            </form>
        );
    }
    
}