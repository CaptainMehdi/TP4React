import React, {useState} from "react";
import FooterAdmin from "../Admin/FooterAdmin";
import FooterClient from "./FooterClient";
import {useEffect} from "react";
import ListAllDocument from "../ListDocument/ListAllDocument";

const PageClient = () =>{
    return(
        <div>
            <div className="container">
                <div className="textBienvenue">
                    <h2>Vous pouvez voir tous les documents de la bibliotheque</h2>
                </div>
                <div style={{margin: "5px"}}>
                    Liste de Documents :
                    <br/>
                    <ListAllDocument />

                </div>
            </div>

            <FooterClient/>
        </div>
    )
}

export default PageClient