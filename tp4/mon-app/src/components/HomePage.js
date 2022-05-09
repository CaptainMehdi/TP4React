import React from "react";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import AdminAddClient from "./Admin/AdminAddClient";
import AdminAddDocuments from "./Admin/AdminAddDocuments";
import Emprunts from "./Admin/Emprunts";
import RetourEmprunt from "./Admin/RetourEmprunt";
import ChoixUser from "./ChoixUser";
import FooterAdmin from "./Admin/FooterAdmin";

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
            <FooterAdmin />
        </div>



    )
}
export default HomePage