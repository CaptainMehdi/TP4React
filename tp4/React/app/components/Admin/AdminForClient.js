import React from "react";
import FooterAdmin from "./FooterAdmin";

const AdminForClient = () => {
    return (
        <div>
            <div className="container">
                <div className="textBienvenue">
                    <h2>Vous pouvez voir tous les clients et on ajoutait</h2>
                    <ul className="textDoc">
                        <li>Appuyer sur ce boutton pour ajouter un Clients
                            <button className="bouttonAjout">Cree</button>
                        </li>
                    </ul>
                </div>
            </div>
            <FooterAdmin/>
        </div>


    )
}

export default AdminForClient
