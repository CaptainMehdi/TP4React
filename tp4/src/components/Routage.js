import React from "react";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import Clients from "./Clients";
import Documents from "./Documents";
import Emprunts from "./Emprunts";
import RetourEmprunt from "./RetourEmprunt";
import HomePage from "./HomePage";
import ChoixUser from "./ChoixUser";

const Routage = () =>{
    return (
        <div>
            <Router>
                <div>
                    <Switch>
                        <Route exact path="/" component={ChoixUser}/>
                        <Route exact path="/home" component={HomePage}/>
                        <Route exact path="/clients" component={Clients}/>
                        <Route exact path="/documents" component={Documents}/>
                        <Route exact path="/emprunts" component={Emprunts} />
                        <Route exact path="/retourEmprunt" component={RetourEmprunt}/>
                        <Route exact path="/user" component={ChoixUser}/>
                    </Switch>
                </div>
            </Router>
        </div>
    )
}

export default Routage