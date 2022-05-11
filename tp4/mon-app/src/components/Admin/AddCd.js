import {useState} from "react";
import FooterAdmin from "./FooterAdmin";

const AddCd = () => {
    const [titre, setTitre] = useState('')
    const [auteur, setAuteur] = useState('')
    const [publication, setPublication] = useState('')
    const [categorie, setCategorie] = useState('')
    const [disponibilite, setDisponibilite] = useState('')
    const [duree, setDuree] = useState('')

    const onSubmitCd = (e) => {
        e.preventDefault()

        if (!titre) {
            alert('Ajouter le titre')
            return
        } else if (!auteur) {
            alert('Ajouter le auteur')
            return
        } else if (!publication) {
            alert('Ajouter le publication')
            return
        }
        const cd = {titre, auteur, publication, categorie, disponibilite, duree}
        fetch("http://localhost:2002/todos/addCd", {
            method: "POST",
            headers: {"Content-type": "application/json"},
            body: JSON.stringify(cd)
        }).then(() => {
            console.log("new Cd added")
        })
        setTitre('')
        setAuteur('')
        setPublication('')
        setDuree('')
        setDisponibilite('')
    }

    return (
        <div>
            <div className="container">
                <h2 className="textBienvenue">Vous pouvez ajouter un Cd</h2>
                <form className='add-form' onSubmit={onSubmitCd}>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Titre</label>
                        <input type='text' placeholder='Titre'
                               value={titre}
                               onChange={(e) => setTitre(e.target.value)}/>
                    </div>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Auteur</label>
                        <input type='text' placeholder='Auteur'
                               value={auteur}
                               onChange={(e) => setAuteur(e.target.value)}/>
                    </div>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Date de publication</label>
                        <input type='text' placeholder='Publication'
                               value={publication}
                               onChange={(e) => setPublication(e.target.value)}/>
                    </div>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Categorie</label>
                        <input type='text' placeholder='Categorie'
                               value={categorie}
                               onChange={(e) => setCategorie(e.target.value)}/>
                    </div>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Disponibilite</label>
                        <input type='text' placeholder='Publication'
                               value={disponibilite}
                               onChange={(e) => setDisponibilite(e.target.value)}/>
                    </div>
                    <div className='form-control'>
                        <label style={{margin: "5px"}}>Duree</label>
                        <input type='text' placeholder='duree'
                               value={duree}
                               onChange={(e) => setDuree(e.target.value)}/>
                    </div>
                    <input type='submit' value='Save Cd' className='btn btn-block'/>
                </form>
            </div>
            <FooterAdmin/>
        </div>
    )
}
export default AddCd
