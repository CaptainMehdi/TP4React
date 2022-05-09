import React from "react";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import AdminForClient from "./Admin/AdminForClient";
import AdminForDocuments from "./Admin/AdminForDocuments";
import Emprunts from "./Admin/Emprunts";
import RetourEmprunt from "./Admin/RetourEmprunt";
import HomePage from "./HomePage";
import ChoixUser from "./ChoixUser";
import PageClient from "./Client/PageClient";

const Routage = () =>{
    return (
        <div>
            <Router>
                <div>
                    <Switch>
                        <Route exact path="/" component={ChoixUser}/>
                        <Route exact path="/home" component={HomePage}/>
                        <Route exact path="/client" component={PageClient}/>
                        <Route exact path="/clients" component={AdminForClient}/>
                        <Route exact path="/documents" component={AdminForDocuments}/>
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