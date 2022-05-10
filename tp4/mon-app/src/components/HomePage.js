import React from "react";
import FooterAdmin from "./Admin/FooterAdmin";

const HomePage = () =>{
    return(
        <div>
            <div className="container">
                <div className={"textBienvenue"}>
                    <h2>Bienvenue a la bibliotheque de Javatown</h2>
                    Veuiller selectionner une des option qui se trouve sous cette
                    boite
                </div>
            </div>
            <FooterAdmin />
        </div>



    )
}
export default HomePage