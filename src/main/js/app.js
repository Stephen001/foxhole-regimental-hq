const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {regiments: [], item_types: [], items: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/regiments'}).done(response => {
			this.setState({regiments: response.entity._embedded.regiments});
		});
		client({method: 'GET', path: '/api/itemTypes'}).done(response => {
			this.setState({item_types: response.entity._embedded.item_types});
		});
		client({method: 'GET', path: '/api/items'}).done(response => {
			this.setState({items: response.entity._embedded.items});
		});
	}

	render() {
		return (
			<RegimentList regiments={this.state.regiments}/>
		)
	}
};

class RegimentList extends React.Component {
	render() {
		const regiments = this.props.regiments.map(regiment =>
			<Regiment key={regiment._links.self.href} regiment={regiment}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Name</th>
						<th>Faction</th>
					</tr>
					{regiments}
				</tbody>
			</table>
		)
	}
};

class Regiment extends React.Component {
	render() {
		return (
			<tr>
				<td>{this.props.regiment.name}</td>
				<td>{this.props.regiment.faction}</td>
			</tr>
		)
	}
};

ReactDOM.render(
	<App />,
	document.getElementById('react')
);