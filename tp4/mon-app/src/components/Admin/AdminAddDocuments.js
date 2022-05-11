import React from "react";
import FooterAdmin from "./FooterAdmin";
import {Link} from "react-router-dom";
import ListLivre from "../ListDocument/ListLivre";
import ListCd from "../ListDocument/ListCd";
import ListDvd from "../ListDocument/ListDvd";

const AdminAddDocuments = () => {

    return (
        <div>
            <div className="container">
                <h2 className="textBienvenue">Vous pouvez voir tous les documents et en ajouter</h2>
                <p className="textDoc">Choissisais le type de documents :</p>
                <ul className="textDoc">
                    <li>Appuyer sur ce boutton pour ajouter un Livre
                        <Link to="/addLivre"><button className="bouttonAjout">Cree</button></Link>
                    </li>
                    <li>Appuyer sur ce boutton pour ajouter un Cd
                       <Link to="/addCd" ><button className="bouttonAjout">Cree</button></Link>
                    </li>
                    <li>Appuyer sur ce boutton pour ajouter un Dvd
                        <Link to="/addDvd"><button className="bouttonAjout">Cree</button></Link>
                    </li>

                </ul>
                <div>
                    Liste de Documents :
                    <div>
                        Les Livres:
                        <ListLivre />
                        Les Cds:
                        <ListCd/>
                        Les Dvds:
                        <ListDvd/>
                    </div>
                </div>
            </div>
            <FooterAdmin/>
        </div>

    )
}
export default AdminAddDocuments