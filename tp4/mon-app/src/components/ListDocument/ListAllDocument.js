import React, {useEffect, useState} from "react";

const ListAllDocument = () =>{
    const [documents, setDocuements] = useState([])

    useEffect(() => {
        const getDocuments = async () => {
            const tasksFromServer = await fetchDocuments()
            setDocuements(tasksFromServer)

        }
        getDocuments()
    }, [])

    const fetchDocuments = async () => {
        const res = await fetch('http://localhost:2002/todos/getAllDocument')
        const data = await res.json()
        return data
    }
    return(
        <div>
            {documents.map((document) =>(
                <div className="tableElement" key={document.id}>
                    <h5>ID: {document.id}</h5>
                    <h5>Titre: {document.titre}</h5>
                    <h5>Auteur: {document.auteur}</h5>
                    <h5>Categorie: {document.categorie}</h5>
                </div>
            ))}
        </div>
    )
}
export default ListAllDocument