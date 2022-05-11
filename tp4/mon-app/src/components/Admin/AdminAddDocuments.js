import React from "react";
import FooterAdmin from "./FooterAdmin";
import {Link} from "react-router-dom";

const AdminAddDocuments = () => {

    return (
        <div>
            <div className="container">
                <h2 className="textBienvenue">Vous pouvez voir tous les documents et on ajoutait</h2>
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
                        Les livres:

                    </div>
                </div>
            </div>
            <FooterAdmin/>
        </div>

    )
}
export default AdminAddDocuments