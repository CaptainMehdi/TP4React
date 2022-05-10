import React from "react";
import { Link} from "react-router-dom";

const ChoixUser = () => {
    return (
        <div className="container">
            <h2>Choix de l'utilisateur</h2>

            <ul onClick={() => window.location.reload()} style={{listStyleType:"none",textDecoration:"none"}}>
                <li>
                    <Link className="lien" to="/client" >Acceder en temps que Client<button className="btnUser" style={{backgroundColor:"blueviolet"}}>Client</button></Link>
                </li>
                <li>
                    <Link className="lien" to="/home">Acceder en temps que Admin<button className="btnUser" style={{backgroundColor:"cornflowerblue"}}>Admin</button></Link>
                </li>
            </ul>
        </div>
    )

}

export default ChoixUser