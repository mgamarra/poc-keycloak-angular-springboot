export const environment = {
  production: false,
  envName: 'local',
    // Url of the Identity Provider
    issuer: 'http://localhost:8080/auth/',

    // Realm
  realm: 'stn',

    // The SPA's id.
    // The SPA is registerd with this id at the auth-serverß
    clientId: 'spa-stn',
};
