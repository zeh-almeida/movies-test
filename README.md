# Getting Started

## Loading Movie Data
All data is read into an in-memory database at the project start-up phase.
In order to change the default load, you must update the file located at: `src/main/resources/movielist.csv`

## File structure
The CSV file must have the following columns:
`year;title;studios;producers;winner`

Entries with multiple Producers and/or Studios can separate their contents with `,` or `and`.

For example:

```
1980;Cruising;Lorimar Productions, United Artists;Jerry Weintraub;
1983;Hercules;MGM, United Artists, Cannon Films;Yoram Globus and Menahem Golan;
```

# Running
Once the application is online, the default location, `http://localhost:8080/`
 will direct you to the Swagger page with all the available endpoints