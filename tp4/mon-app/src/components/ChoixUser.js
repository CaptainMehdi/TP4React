import React from "react";
import {BrowserRouter as Router, Link, Route, Switch} from "react-router-dom";
import AdminAddClient from "./Admin/AdminAddClient";
import HomePage from "./HomePage";
import PageClient from "./Client/PageClient";

const ChoixUser = () => {
    return (
        <div className="container">
            <h2>Choix de l'utilisateur</h2>
            <Router>
                <div>
                    <Switch>
                        <Route exact path="/home" component={HomePage}/>
                        <Route exact path="/client" component={PageClient}/>
                    </Switch>
                </div>
            </Router>
            <ul onClick={() => window.location.reload()} style={{listStyleType:"none",textDecoration:"none"}}>
                <li>
                    <Link class="lien" to="/client" >Acceder en temps que Client<button className="btnUser" style={{backgroundColor:"blueviolet"}}>Client</button></Link>
                </li>
                <li>
                    <Link class="lien" to="/home">Acceder en temps que Admin<button className="btnUser" style={{backgroundColor:"cornflowerblue"}}>Admin</button></Link>
                </li>
            </ul>
        </div>
    )

}

export default ChoixUser