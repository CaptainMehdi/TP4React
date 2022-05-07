import React from "react";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import Clients from "./Clients";
import Documents from "./Documents";
import Emprunts from "./Emprunts";
import RetourEmprunt from "./RetourEmprunt";
import ChoixUser from "./ChoixUser";
import Footer from "./Footer";

const HomePage = () =>{
    return(
        <div>
            <div className="container">
                <div className={"textBienvenue"}>
                    <h2>Bienvenue a la bibliotheque de Javatown</h2>
                    Veuiller selectionner une des option qui se trouve sous cette
                    boite
                </div>
            </div>
            <Footer />
        </div>



    )
}
export default HomePage