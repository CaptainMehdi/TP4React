import React from "react";
import {Link} from "react-router-dom";

const Footer = () =>{

    return  (
        <div className="footer">
            <ul onClick={() => window.location.reload()}>
                <Link to="/documents">
                    <li className="navlinks">Ajouter un document</li>
                </Link>
                <Link to="/clients" >
                    <li className="navlinks" >Ajouter un client</li>
                </Link>
            </ul>
        </div>
    )
}

export default Footer