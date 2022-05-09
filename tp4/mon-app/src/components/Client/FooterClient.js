import React from "react";
import {Link} from "react-router-dom";

const FooterClient = () =>{

    return  (
        <div className="footer">
            <ul onClick={() => window.location.reload()}>
                <Link class="btnlien" to="/user">
                    <button className="navlinks">Choix Utilisateur</button>
                </Link>
            </ul>
        </div>
    )
}

export default FooterClient