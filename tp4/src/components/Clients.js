import React from "react";
import Footer from "./Footer";

const Clients = () => {
    return (
        <div>
            <div className="container">
                <div className="textBienvenue">
                    <h2>Vous pouvez voir tous les clients et on ajoutait</h2>
                    <p className="textDoc">Choissisais le type de client :</p>
                    <ul className="textDoc">
                        <li>Appuyer sur ce boutton pour ajouter un Livre
                            <button className="bouttonAjout">Cree</button>
                        </li>
                    </ul>
                </div>
            </div>
            <Footer/>
        </div>


    )
}

export default Clients
