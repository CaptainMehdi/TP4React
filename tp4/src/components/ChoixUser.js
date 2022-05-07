import React from "react";
import {BrowserRouter as Router, Link, Route, Switch} from "react-router-dom";
import Clients from "./Clients";
import HomePage from "./HomePage";

const ChoixUser = () => {
    return (
        <div className="container">
            <h2>Choix de l'utilisateur</h2>
            <Router>
                <div>
                    <Switch>
                        <Route exact path="/home" component={HomePage}/>
                        <Route exact path="/clients" component={Clients}/>
                    </Switch>
                </div>
            </Router>
            <ul onClick={() => window.location.reload()} style={{listStyleType:"none",textDecoration:"none"}}>
                <li>
                    <Link to="/clients" >Acceder en temps que Client<button className="btnUser">Client</button></Link>
                </li>
                <li>
                    <Link to="/home">Acceder en temps que Client<button className="btnUser">Admin</button></Link>
                </li>
            </ul>
        </div>
    )

}

export default ChoixUser