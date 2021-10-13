import { Fragment, useState } from "react";
import { connect } from "react-redux";
import generateRandom from "../actions/GenerateRandom";

const Form = (props)=>
{
    const [state, setState] = useState();

    const onSubmit = (e)=>
    {
        e.preventDefault();
        console.log(state);
        props.dispatch(generateRandom(state));
    }

    return (<Fragment>
    <form onSubmit={onSubmit}>
      <label htmlFor="list">Ingrese el rango de inicio y final respectivamente:</label>
      <br />
      <input id="startRange" type="number" 
        onChange={(e) => setState({"startRange":e.target.value})}
      ></input>
      <br />
      <input id="endRange" type="number" 
        onChange={(e) => setState({...state, "endRange":e.target.value})}
      ></input>
      <br />
      <button type="submit" disabled={props.loading}>
        Enviar
      </button>
    </form>
    </Fragment>);
}

const stateMapToPros = state => {
    return {
      loading: state.view.loading
    }
}

export default connect(stateMapToPros)(Form);