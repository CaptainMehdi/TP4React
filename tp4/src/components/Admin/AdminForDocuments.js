import React from "react";
import FooterAdmin from "./FooterAdmin";

const Documents = () => {
    return (
        <div>
            <div className="container">
                <h2 className="textBienvenue">Vous pouvez voir tous les documents et on ajoutait</h2>
                <p className="textDoc">Choissisais le type de documents :</p>
                <ul className="textDoc">
                    <li>Appuyer sur ce boutton pour ajouter un Livre
                        <button className="bouttonAjout">Cree</button>
                    </li>
                    <li>Appuyer sur ce boutton pour ajouter un Cd
                        <button className="bouttonAjout">Cree</button>
                    </li>
                    <li>Appuyer sur ce boutton pour ajouter un Dvd
                        <button className="bouttonAjout">Cree</button>
                    </li>

                </ul>
            </div>
            <FooterAdmin/>
        </div>

    )
}
export default Documents