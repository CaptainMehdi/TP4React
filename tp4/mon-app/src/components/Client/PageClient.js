import React from "react";
import FooterAdmin from "../Admin/FooterAdmin";
import ListeDocument from "../ListeDocument";
import FooterClient from "./FooterClient";

const PageClient = () =>{
    return(
        <div>
            <div className="container">
                page du client <br/>
                liste de document dispo et non dispo
                <ListeDocument />
            </div>

            <FooterClient/>
        </div>
    )
}

export default PageClient